package com.astronaut.scheduler.exception;


// custom exception to handle invalid time such as some random string or end time is less then start
public class InvalidTimeException extends Exception {
    public InvalidTimeException(String message) {
        super(message);
    }
}