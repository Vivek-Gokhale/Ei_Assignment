package com.astronaut;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.manager.AddTaskService;
import com.astronaut.scheduler.manager.EditTaskService;
import com.astronaut.scheduler.manager.MarkCompleteService;
import com.astronaut.scheduler.manager.RemoveTaskService;
import com.astronaut.scheduler.manager.ScheduleManager;
import com.astronaut.scheduler.manager.ViewTaskService;
import com.astronaut.scheduler.observer.ConsoleObserver;
import com.astronaut.scheduler.observer.FileLoggerObserver;
import com.astronaut.scheduler.observer.Notifier;
import com.astronaut.scheduler.observer.Observer;

public class Main {

    public static void main(String[] args) {
    	
    	//creating notifier
    	Notifier notifier = new Notifier();
    	// creating observers and subscribing to notifier
    	Observer consoleObserver = new ConsoleObserver();
    	Observer fileLoggerObserver = new FileLoggerObserver();
    	notifier.subscribe(consoleObserver);
    	notifier.subscribe(fileLoggerObserver);
    	
    	
        AddTaskService addService = new AddTaskService(notifier);
        MarkCompleteService markService = new MarkCompleteService(notifier);
        RemoveTaskService removeService = new RemoveTaskService(notifier);
        ViewTaskService viewService = new ViewTaskService(notifier);
        EditTaskService editService = new EditTaskService(notifier);
        
        System.out.println("=== Astronaut Daily Schedule Organizer Demo ===\n");

        // Positive Case 1
        try {
            addService.addTask("Morning Exercise", "07:00", "08:00", "High");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Positive Case 2
        try {
        	addService.addTask("Team Meeting", "09:00", "10:00", "Medium");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Positive Case 3
        System.out.println("\n-- View Tasks --");
        try {
        	viewService.viewTasks();
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Positive Case 3
        System.out.println("\n-- View Tasks --");
        try {
        	viewService.viewTasks("High");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        

        // Positive Case 4
        try {
        	removeService.removeTask("Morning Exercise");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Positive Case 5
        try {
        	addService.addTask("Lunch Break", "12:00", "13:00", "Low");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Negative Case 1 (overlap)
        try {
        	editService.editTask("Team Meeting", "Training Session", "09:30", "10:30", "High");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Negative Case 2 (remove non-existent)
        try {
        	removeService.removeTask("Non-existent Task");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Negative Case 3 (invalid time)
        try {
        	addService.addTask("Invalid Time Task", "25:00", "26:00", "Low");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Negative Case 4 (overlap again)
        try {
        	addService.addTask("Overlap Task", "08:30", "09:30", "Medium");
        } catch (TaskConflictException | InvalidTimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Positive Case 5
        System.out.println("\n-- View Tasks Priority wise--");
        try {
        	viewService.viewTasks("High");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Positive Case 6
        System.out.println("\n-- Mark task as Completed --");
        try {
        	markService.markTaskCompleted("Training Session");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Positive Case 7 (view tasks again)
        System.out.println("\n-- Final Tasks --");
        try {
        	viewService.viewTasks();
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
