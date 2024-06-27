package ru.design.livecoding.operation;

import java.util.Objects;

public class Operation {
    private final String userId;
    private final OperationType operationType;

    public Operation(String userId, OperationType operationType) {
        this.userId = userId;
        this.operationType = operationType;
    }

    public String getUserId() {
        return userId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return Objects.equals(userId, operation.userId) && operationType == operation.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, operationType);
    }
}
