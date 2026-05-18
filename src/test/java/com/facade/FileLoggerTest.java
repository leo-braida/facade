package com.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileLoggerTest {

    @Test
    void testAppendToFile(@TempDir Path tempDir) throws IOException {
        Path logFile = tempDir.resolve("test_log.txt");
        FileLogger fileLogger = new FileLogger(logFile.toString());
        
        fileLogger.appendToFile(LogPriority.URGENT, "Database down");
        
        String content = Files.readString(logFile);
        assertTrue(content.contains("URGENT"));
        assertTrue(content.contains("Database down"));
    }
    
    @Test
    void testAppendToFileMultipleLogs(@TempDir Path tempDir) throws IOException {
        Path logFile = tempDir.resolve("test_log.txt");
        FileLogger fileLogger = new FileLogger(logFile.toString());
        
        fileLogger.appendToFile(LogPriority.NORMAL, "Message 1");
        fileLogger.appendToFile(LogPriority.LOW, "Message 2");
        
        String content = Files.readString(logFile);
        assertTrue(content.contains("NORMAL"));
        assertTrue(content.contains("Message 1"));
        assertTrue(content.contains("LOW"));
        assertTrue(content.contains("Message 2"));
    }
}
