package com.astronaut.scheduler.factory;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.utils.PriorityLevel;

/**
 * Factory Interface for creating Task objects.
 * 
 * This abstraction allows us to hide the object creation details from the client code.
 * Using an interface makes the design more flexible and testable,
 * since different implementations of task creation can be swapped easily.
 */
public interface ITaskFactory {
	
	/**
	 * Create a Task object after validating input parameters.
	 * 
	 * @param desc     - Task description (what the astronaut needs to do)
	 * @param start    - Start time of task in string format (HH:MM)
	 * @param end      - End time of task in string format (HH:MM)
	 * @param priority - Task priority (High, Medium, Low)
	 * @return Task    - Returns a new Task object
	 * @throws InvalidTimeException if start/end times are invalid or not in correct format
	 */
	public Task createTask(String desc, String start, String end, PriorityLevel priority) throws InvalidTimeException;
}
