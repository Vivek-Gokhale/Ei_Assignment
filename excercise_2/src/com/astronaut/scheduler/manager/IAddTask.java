package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;

// interface for adding tasks
public interface IAddTask {
    
    // add a new task with given details
    void addTask(String description, String start, String end, String priorityStr) 
            throws InvalidTimeException, TaskConflictException;
}
