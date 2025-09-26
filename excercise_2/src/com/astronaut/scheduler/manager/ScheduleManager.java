package com.astronaut.scheduler.manager;


import java.util.Comparator;
import java.util.TreeSet;

import com.astronaut.scheduler.model.Task;




// uses singleton design pattern to keep only one instance of ScheduleManager to manage task operation 
public class ScheduleManager {
	private static ScheduleManager instance;
	private TreeSet<Task> tasks; // used Tree set (balanced binary tree)  to keep task in sorted form as per start time as per requirement 
	
	
	private ScheduleManager() {
        tasks = new TreeSet<>(Comparator.comparing(Task::getStartTime));
    }
	
	
	//implement singleton design pattern to create object of schedule manager only if instance not exist
	public static ScheduleManager getInstance()
	{
		if(instance == null)
		{
			instance = new ScheduleManager();
		}
		return instance;
		
	}
	
	public TreeSet<Task> getTasks()
	{
		return tasks;
	}
	
	
}
