package ru.design.creational.singleton.ex1;

public final class ProgramLogger {
    private static ProgramLogger programLogger = null;
    private static StringBuilder logFile = new StringBuilder();

    private ProgramLogger() {
        logFile.append("This is log file;\n\n");
    }

    public static synchronized ProgramLogger getInstance() {
        if (programLogger == null) {
            return new ProgramLogger();
        }
        return programLogger;
    }

    public void addLogInfo(String info) {
        logFile.append(info);
    }

    public String print() {
        return logFile.toString();
    }
}
