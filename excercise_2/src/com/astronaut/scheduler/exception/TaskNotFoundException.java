package com.astronaut.scheduler.exception;


//custom exception handle when view task or remove task or edit task operation performed and task not found
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}