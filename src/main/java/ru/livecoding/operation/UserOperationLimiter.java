package ru.livecoding.operation;


import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Сервис, определяющий разрешено ли пользователю делать операцию
 * на основе лимитов операций (для каждого пользователя свой лимит)
 */
public class UserOperationLimiter {
    private final Map<OperationType, Map<String, Queue<ProcessedOperation>>> operationTypeMapMap;

    private final Long readLimitPerMinute;

    private final Long writeLimitPerMinute;

    public UserOperationLimiter(
            List<User> users,
            Long readLimitPerMinute,
            Long writeLimitPerMinute
    ) {
        Map<String, Queue<ProcessedOperation>> readOperations = users.stream()
                .collect(Collectors.toMap(
                        User::id,
                        user -> new ConcurrentLinkedQueue<>()
                ));
        Map<String, Queue<ProcessedOperation>> writeOperations = users.stream()
                .collect(Collectors.toMap(
                        User::id,
                        user -> new ConcurrentLinkedQueue<>()
                ));
        operationTypeMapMap = Map.of(
                OperationType.READ, readOperations,
                OperationType.WRITE, writeOperations
        );
        this.readLimitPerMinute = readLimitPerMinute;
        this.writeLimitPerMinute = writeLimitPerMinute;
    }

    /**
     * Проверяет допустимо ли пользователю совершать операцию.
     * Принимает решение на основе лимитов для разных типов операций
     */
    public boolean isUserAllowedToPerform(Operation operation) {
        Queue<ProcessedOperation> operationQueue = operationTypeMapMap
                .get(operation.getOperationType())
                .get(operation.getUserId());
        if (operationQueue == null) {
            throw new IllegalStateException("No such user with id = %s".formatted(operation.getUserId()));
        }

        removeOldOperations(operationQueue);
        int operationCounter = operationQueue.size();

        if (operation.getOperationType().equals(OperationType.READ)) {
            return operationCounter < readLimitPerMinute;
        }
        return operationCounter < writeLimitPerMinute;
    }

    /**
     * Обработать сделанную операцию пользователем
     */
    public void processPerformedOperation(Operation operation) {
        Queue<ProcessedOperation> operationQueue = operationTypeMapMap
                .get(operation.getOperationType())
                .get(operation.getUserId());

        if (operationQueue == null) {
            throw new IllegalStateException("No such user with id = %s".formatted(operation.getUserId()));
        }

        operationQueue.add(new ProcessedOperation(
                operation.getUserId(),
                operation.getOperationType(),
                getCurrentTimeSeconds()
        ));
    }

    /**
     * Получить текущее время в миллисекундах
     */
    public Long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    private void removeOldOperations(Queue<ProcessedOperation> processedOperationsQueue) {
        long currentTime = getCurrentTimeSeconds();
        while (!processedOperationsQueue.isEmpty()) {
            var processedOperation = processedOperationsQueue.peek();
            if (currentTime - 60 > processedOperation.operationTime()) {
                processedOperationsQueue.poll();
            } else {
                break;
            }
        }
    }
}
