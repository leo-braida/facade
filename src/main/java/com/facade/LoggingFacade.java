package com.facade;

public class LoggingFacade {

    private final ConsoleLogger consoleLogger;
    private final FileLogger fileLogger;

    public LoggingFacade(ConsoleLogger consoleLogger, FileLogger fileLogger) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
    }

    public void logUrgent(String message) {
        consoleLogger.writeToConsole(LogPriority.URGENT, message);
        fileLogger.appendToFile(LogPriority.URGENT, message);
    }

    public void logNormal(String message) {
        consoleLogger.writeToConsole(LogPriority.NORMAL, message);
        fileLogger.appendToFile(LogPriority.NORMAL, message);
    }

    public void logLow(String message) {
        consoleLogger.writeToConsole(LogPriority.LOW, message);
        fileLogger.appendToFile(LogPriority.LOW, message);
    }
}
