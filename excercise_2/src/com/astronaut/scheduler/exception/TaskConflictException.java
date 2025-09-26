package com.astronaut.scheduler.exception;

//custom exception to handle when conflict occurs between scheduled task
public class TaskConflictException extends Exception {
    public TaskConflictException(String message) {
        super(message);
    }
}