package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;

public interface IAddTask {
	void addTask(String description, String start, String end, String priorityStr) throws InvalidTimeException, TaskConflictException;
}
