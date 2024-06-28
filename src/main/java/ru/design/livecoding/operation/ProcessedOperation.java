package ru.design.livecoding.operation;

public record ProcessedOperation(String userId,
                               OperationType operationType,
                               Long operationTime) {
}
