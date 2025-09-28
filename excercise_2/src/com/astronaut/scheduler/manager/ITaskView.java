package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface ITaskView extends ITaskViewByPriority{
	void viewTasks() throws TaskNotFoundException;
}
