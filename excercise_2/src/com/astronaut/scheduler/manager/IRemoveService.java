package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface IRemoveService {
	void removeTask(String description) throws TaskNotFoundException;
}
