package ru.design.creational.singleton.ex1;

public class Demo {
    public static void main(String[] args) {
        ProgramLogger programLogger = ProgramLogger.getInstance();

        System.out.println(ProgramLogger.getInstance());
        System.out.println(ProgramLogger.getInstance());
        System.out.println(ProgramLogger.getInstance());
    }
}
