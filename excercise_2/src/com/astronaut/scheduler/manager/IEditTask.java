package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;

// interface for editing existing tasks
public interface IEditTask {
    
    // edit an existing task by its description with new details
    void editTask(String descriptionTarget, String newDescription, 
                  String start, String end, String priorityStr)
            throws InvalidTimeException, TaskConflictException;
}
