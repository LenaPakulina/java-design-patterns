package ru.livecoding.threadprinter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Реализовать класс, который последовательно разрешает производить
 * операции Runnable (произвольные) с учетом порядка вывода:
 * - Сначала первый должен произвести Runnable, затем второй и третий
 */

public class Printer {
    private CurrentState state = CurrentState.FIRST_STATE;

    public void first(Runnable runnable) throws InterruptedException {
        execState(CurrentState.FIRST_STATE, runnable);
    }

    public void second(Runnable runnable) throws InterruptedException {
        execState(CurrentState.SECOND_STATE, runnable);
    }

    public void third(Runnable runnable) throws InterruptedException {
        execState(CurrentState.THIRD_STATE, runnable);
    }

    public synchronized void execState(CurrentState expectedState, Runnable runnable) throws InterruptedException {
        while (state != expectedState) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        runnable.run();
        state = state.nextState();
        notifyAll();
    }

    private static Thread createThread(Printer printer, PrinterMethod method, String message) {
        return new Thread(() -> {
            try {
                method.execute(() -> System.out.println(message));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        // Создание потоков
        Thread th1 = createThread(printer, printer::first, "thread1");
        Thread th2 = createThread(printer, printer::second, "thread2");
        Thread th3 = createThread(printer, printer::third, "thread3");

        // Повторное создание потоков для демонстрации
        Thread th4 = createThread(printer, printer::first, "thread1");
        Thread th5 = createThread(printer, printer::second, "thread2");
        Thread th6 = createThread(printer, printer::third, "thread3");

        Thread th7 = createThread(printer, printer::first, "thread1");
        Thread th8 = createThread(printer, printer::second, "thread2");
        Thread th9 = createThread(printer, printer::third, "thread3");

        Thread th10 = createThread(printer, printer::first, "thread1");
        Thread th11 = createThread(printer, printer::second, "thread2");
        Thread th12 = createThread(printer, printer::third, "thread3");

        Thread th13 = createThread(printer, printer::first, "thread1");
        Thread th14 = createThread(printer, printer::second, "thread2");
        Thread th15 = createThread(printer, printer::third, "thread3");

        // Запуск потоков
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();
        th11.start();
        th12.start();
        th13.start();
        th14.start();
        th15.start();
    }
}
