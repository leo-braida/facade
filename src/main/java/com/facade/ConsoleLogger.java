package com.facade;

public class ConsoleLogger {

    public void writeToConsole(LogPriority priority, String message) {
        System.out.println(formatForConsole(priority, message));
    }

    private String formatForConsole(LogPriority priority, String message) {
        return "[" + priority.name() + "] " + message;
    }
}
