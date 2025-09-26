package com.astronaut.scheduler.factory;

import java.time.LocalTime;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeValidator;


// uses factory design pattern to hide object creation logic from client side
public class TaskFactory {
	public Task createTask(String desc, String start, String end, PriorityLevel priority) throws InvalidTimeException
	{
		
		if(!TimeValidator.isValidFormat(end) || !TimeValidator.isValidFormat(start) || TimeValidator.parseTime(end).isBefore(TimeValidator.parseTime(start)))
		{
			throw new InvalidTimeException("Invalid time.");
		}
		LocalTime startTime = TimeValidator.parseTime(start);
		LocalTime endTime = TimeValidator.parseTime(end);
		
		return new Task(desc, startTime, endTime, priority);
	}
	
	
}
