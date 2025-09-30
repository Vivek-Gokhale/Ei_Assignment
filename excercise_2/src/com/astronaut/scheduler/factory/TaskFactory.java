package com.astronaut.scheduler.factory;

import java.time.LocalTime;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeValidator;

/**
 * Concrete implementation of ITaskFactory.
 * 
 * Uses the Factory Design Pattern to centralize the logic of 
 * creating Task objects. This hides the complexity of parsing
 * times and validating inputs from the client code.
 */
public class TaskFactory implements ITaskFactory {
	
	/**
	 * Creates a new Task object after validating start/end times.
	 * 
	 * Steps:
	 * 1. Validate the format of start and end times using TimeValidator.
	 * 2. Ensure that end time is not before start time.
	 * 3. Convert string times into LocalTime objects.
	 * 4. Construct and return a Task object.
	 * 
	 * @param desc     - Task description
	 * @param start    - Start time in HH:MM format
	 * @param end      - End time in HH:MM format
	 * @param priority - Priority level of the task
	 * @return Task    - New validated Task object
	 * @throws InvalidTimeException if input times are invalid or logically incorrect
	 */
	public Task createTask(String desc, String start, String end, PriorityLevel priority) throws InvalidTimeException {
		
		// Validate time format and logical correctness
		if (!TimeValidator.isValidFormat(end) 
				|| !TimeValidator.isValidFormat(start) 
				|| TimeValidator.parseTime(end).isBefore(TimeValidator.parseTime(start))) {
			
			// Throw exception if invalid
			throw new InvalidTimeException("Invalid time.");
		}
		
		// Convert start and end times to LocalTime
		LocalTime startTime = TimeValidator.parseTime(start);
		LocalTime endTime = TimeValidator.parseTime(end);
		
		// Create and return Task object
		return new Task(desc, startTime, endTime, priority);
	}
}
