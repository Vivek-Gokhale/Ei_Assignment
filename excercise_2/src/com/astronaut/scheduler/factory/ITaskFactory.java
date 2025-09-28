package com.astronaut.scheduler.factory;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.utils.PriorityLevel;

public interface ITaskFactory {
	 Task createTask(String desc, String start, String end, PriorityLevel priority) throws InvalidTimeException;
}
