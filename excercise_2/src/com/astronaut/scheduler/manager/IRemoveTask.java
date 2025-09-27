package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface IRemoveTask {
	void removeTask(String description) throws TaskNotFoundException;
}
