package com.astronaut.scheduler.model;

import java.time.LocalTime;

import com.astronaut.scheduler.utils.PriorityLevel;


// its is task class contains fields, constructors, getter and setter method required for this task management
public class Task {
	private String description;
	private LocalTime startTime;
	private LocalTime endTime;
	private PriorityLevel priority;
	private boolean isCompleted;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public PriorityLevel getPriority() {
		return priority;
	}
	public void setPriority(PriorityLevel priority) {
		this.priority = priority;
	}
	public boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	@Override
	public String toString() {
		return "Task [description=" + description + ", startTime=" + startTime + ", endTime=" + endTime + ", priority="
				+ priority + " IsCompleted = "+ isCompleted+"  ]";
	}
	public Task(String description, LocalTime start, LocalTime end, PriorityLevel priority) {
		super();
		this.description = description;
		this.startTime = start;
		this.endTime = end;
		this.priority = priority;
		this.isCompleted = false;		
	}
	
}
