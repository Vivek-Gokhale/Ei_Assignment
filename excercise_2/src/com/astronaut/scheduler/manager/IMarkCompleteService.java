package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface IMarkCompleteService {
	void markTaskCompleted(String description) throws TaskNotFoundException;
}
