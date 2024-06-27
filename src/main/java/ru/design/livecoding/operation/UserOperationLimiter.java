package ru.design.livecoding.operation;


import java.util.List;
import java.util.Map;

/**
 * Сервис, определяющий разрешено ли пользователю делать операцию
 * на основе лимитов операций (для каждого пользователя свой лимит)
 */
public class UserOperationLimiter {


    public UserOperationLimiter(
            List<User> users,
            Long readLimitPerMinute,
            Long writeLimitPerMinute
    ) {

    }

    /**
     * Проверяет допустимо ли пользователю совершать операцию.
     * Принимает решение на основе лимитов для разных типов операций
     */
    public boolean isUserAllowedToPerform(Operation operation) {
        return false;
    }

    /**
     * Обработать сделанную операцию пользователем
     */
    public void processPerformedOperation(Operation operation) {
    }

    /**
     * Получить текущее время в миллисекундах
     */
    public Long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
