package com.astronaut.scheduler.manager;

import com.astronaut.scheduler.exception.TaskNotFoundException;

public interface ITaskView extends IViewTaskByPriority{
	void viewTasks() throws TaskNotFoundException;
}
