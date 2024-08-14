package ru.livecoding.threadprinter;

/**
 * Перечисление основных состояний перечисления.
 * Происходит последовательное изменение состояний First -> Second -> Third -> First
 */

public enum CurrentState {
    FIRST_STATE,
    SECOND_STATE,
    THIRD_STATE;

    /**
     * Метод для циклического переключения состояний
     */
    public synchronized CurrentState nextState() {
        switch (this) {
            case FIRST_STATE:
                return SECOND_STATE;
            case SECOND_STATE:
                return THIRD_STATE;
            case THIRD_STATE:
                return FIRST_STATE;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
