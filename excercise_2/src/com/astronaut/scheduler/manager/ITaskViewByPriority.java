package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface ITaskViewByPriority {
	void viewTasks(String priority) throws TaskNotFoundException;
}
