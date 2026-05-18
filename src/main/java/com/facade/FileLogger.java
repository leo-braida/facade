package com.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {

    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    public void appendToFile(LogPriority priority, String message) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(formatForFile(priority, message));
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    private String formatForFile(LogPriority priority, String message) {
        return "[" + priority.name() + "] " + message;
    }
}
