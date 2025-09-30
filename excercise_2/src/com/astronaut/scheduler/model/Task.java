package com.astronaut.scheduler.model;

import java.time.LocalTime;

import com.astronaut.scheduler.utils.PriorityLevel;

// Task class contains fields and methods for task management
public class Task {
    private String description;    // task description
    private LocalTime startTime;   // start time of task
    private LocalTime endTime;     // end time of task
    private PriorityLevel priority; // task priority (High/Medium/Low)
    private boolean isCompleted;   // completion status

    // constructor to create a task
    public Task(String description, LocalTime start, LocalTime end, PriorityLevel priority) {
        super();
        this.description = description;
        this.startTime = start;
        this.endTime = end;
        this.priority = priority;
        this.isCompleted = false; // default as not completed
    }

    // getters and setters
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

    // toString method to display task details
    @Override
    public String toString() {
        return "Task [description=" + description 
                + ", startTime=" + startTime 
                + ", endTime=" + endTime 
                + ", priority=" + priority 
                + " IsCompleted=" + isCompleted + "]";
    }
}
