package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface IMarkComplete {
	void markTaskCompleted(String description) throws TaskNotFoundException;
}
