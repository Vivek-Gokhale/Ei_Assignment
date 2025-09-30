package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

// interface for viewing tasks filtered by priority
public interface ITaskViewByPriority {
    
    // view tasks with a specific priority (High/Medium/Low)
    void viewTasks(String priority) throws TaskNotFoundException;
}
