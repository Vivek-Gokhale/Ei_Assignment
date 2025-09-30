package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

// interface for removing tasks
public interface IRemoveTask {
    
    // remove a task using its description
    void removeTask(String description) throws TaskNotFoundException;
}
