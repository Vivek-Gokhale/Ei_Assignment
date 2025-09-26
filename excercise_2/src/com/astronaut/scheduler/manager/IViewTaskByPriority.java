package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface IViewTaskByPriority {
	void viewTasks(String priority) throws TaskNotFoundException;
}
