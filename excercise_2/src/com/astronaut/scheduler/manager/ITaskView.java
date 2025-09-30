package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

// interface for viewing all tasks
// extends ITaskViewByPriority to support viewing by priority as well
public interface ITaskView extends ITaskViewByPriority {
    
    // view all tasks in the schedule
    void viewTasks() throws TaskNotFoundException;
}
