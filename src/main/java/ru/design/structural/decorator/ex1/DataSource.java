package ru.design.structural.decorator.ex1;

/**
 * Интерфейс, задающий базовые операции чтения и записи данных
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}
