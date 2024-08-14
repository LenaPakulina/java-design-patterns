package ru.livecoding.threadprinter;

@FunctionalInterface
interface PrinterMethod {
    void execute(Runnable task) throws InterruptedException;
}
