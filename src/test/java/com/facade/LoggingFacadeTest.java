package com.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class LoggingFacadeTest {

    @Mock
    private ConsoleLogger consoleLogger;

    @Mock
    private FileLogger fileLogger;

    private LoggingFacade loggingFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loggingFacade = new LoggingFacade(consoleLogger, fileLogger);
    }

    @Test
    void testLogUrgent() {
        loggingFacade.logUrgent("System crash");
        
        verify(consoleLogger).writeToConsole(LogPriority.URGENT, "System crash");
        verify(fileLogger).appendToFile(LogPriority.URGENT, "System crash");
    }

    @Test
    void testLogNormal() {
        loggingFacade.logNormal("User action");
        
        verify(consoleLogger).writeToConsole(LogPriority.NORMAL, "User action");
        verify(fileLogger).appendToFile(LogPriority.NORMAL, "User action");
    }

    @Test
    void testLogLow() {
        loggingFacade.logLow("Ping");
        
        verify(consoleLogger).writeToConsole(LogPriority.LOW, "Ping");
        verify(fileLogger).appendToFile(LogPriority.LOW, "Ping");
    }
}
