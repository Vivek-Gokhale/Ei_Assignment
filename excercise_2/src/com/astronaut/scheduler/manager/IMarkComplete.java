package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

// interface for marking tasks as completed
public interface IMarkComplete {
    
    // mark a task as completed using its description
    void markTaskCompleted(String description) throws TaskNotFoundException;
}
