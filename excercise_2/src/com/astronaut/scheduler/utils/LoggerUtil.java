package com.astronaut.scheduler.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


// Handle log mechanism for various exception occurs eg. InvalidTimeException, TaskConflictException, TaskNotFoundException
public class LoggerUtil {
    private static final String LOG_FILE = "scheduler.log";

    public static void log(String msg) {
        String logEntry = "[LOG " + LocalDateTime.now() + "] " + msg;

        FileWriter fw = null;
        try {
            fw = new FileWriter(LOG_FILE, true); // true = append mode
            fw.write(logEntry + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("[Logger Error] Could not write to log file: " + e.getMessage());
        } finally {
        	
        	//closing file writer object to release resources
            if (fw != null) {
                    try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
        }
    }
}
