package com.facade;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleLoggerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ConsoleLogger consoleLogger;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        consoleLogger = new ConsoleLogger();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testWriteToConsoleUrgent() {
        consoleLogger.writeToConsole(LogPriority.URGENT, "System failure");
        assertTrue(outContent.toString().contains("URGENT"));
        assertTrue(outContent.toString().contains("System failure"));
    }

    @Test
    void testWriteToConsoleNormal() {
        consoleLogger.writeToConsole(LogPriority.NORMAL, "User logged in");
        assertTrue(outContent.toString().contains("NORMAL"));
        assertTrue(outContent.toString().contains("User logged in"));
    }

    @Test
    void testWriteToConsoleLow() {
        consoleLogger.writeToConsole(LogPriority.LOW, "Heartbeat");
        assertTrue(outContent.toString().contains("LOW"));
        assertTrue(outContent.toString().contains("Heartbeat"));
    }
}
