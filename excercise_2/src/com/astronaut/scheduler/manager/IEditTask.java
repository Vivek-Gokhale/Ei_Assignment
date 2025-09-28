package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;

public interface IEditTask {
	void editTask(String descriptionTarget, String newDescription, 
            String start, String end, String priorityStr)
throws InvalidTimeException, TaskConflictException;
}
