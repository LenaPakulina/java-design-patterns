package ru.livecoding.operation;

public record ProcessedOperation(String userId,
                               OperationType operationType,
                               Long operationTime) {
}
