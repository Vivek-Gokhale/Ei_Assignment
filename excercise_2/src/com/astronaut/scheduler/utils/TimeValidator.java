package com.astronaut.scheduler.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Utility class to validate and parse time strings in "HH:mm" format
public class TimeValidator {
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm"); // formatter for HH:mm

    // check if string is valid time format
    public static boolean isValidFormat(String time) {
        try {
            LocalTime.parse(time, FORMATTER); // try parsing
            return true;
        } catch (DateTimeParseException e) {
            return false; // invalid format
        }
    }

    // parse string to LocalTime
    public static LocalTime parseTime(String time) {
        return LocalTime.parse(time, FORMATTER);
    }
}
