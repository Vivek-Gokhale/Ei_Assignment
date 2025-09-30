package com.astronaut;

import java.util.Scanner;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.manager.AddTaskManager;
import com.astronaut.scheduler.manager.EditTaskManager;
import com.astronaut.scheduler.manager.MarkCompleteManager;
import com.astronaut.scheduler.manager.RemoveTaskManager;
import com.astronaut.scheduler.manager.ViewTaskManager;
import com.astronaut.scheduler.observer.AstronautObserver;
import com.astronaut.scheduler.observer.Notifier;

public class Main {

    public static void main(String[] args) {
    	
    	// Scanner to take user input from console
    	Scanner sc = new Scanner(System.in);
    	
    	// Creating a notifier (Subject in Observer pattern)
    	// This will notify subscribed astronauts when tasks are added/edited/removed etc.
    	Notifier notifier = new Notifier();
    	
    	// Ask user for number of astronauts to register in crew
    	System.out.print("Enter number of astronauts in crew: ");
    	int n = sc.nextInt();
    	sc.nextLine(); // consume newline after integer input
    	
    	// Loop for each astronaut and register (subscribe) them
    	for (int i=1; i<=n; i++) {
    		System.out.print("Enter Astronaut ID: ");
    		String id = sc.nextLine(); // astronaut unique ID
    		System.out.print("Enter Astronaut Name: ");
    		String name = sc.nextLine(); // astronaut full name
    		
    		// Create observer object for astronaut and subscribe them to notifier
    		AstronautObserver astronaut = new AstronautObserver(id, name);
    		notifier.subscribe(astronaut);
    	}
    	
    	// Create instances of service managers
    	// Each manager handles one operation (Add, Edit, Remove, View, Mark Complete)
        AddTaskManager addService = new AddTaskManager(notifier);
        MarkCompleteManager markService = new MarkCompleteManager(notifier);
        RemoveTaskManager removeService = new RemoveTaskManager(notifier);
        ViewTaskManager viewService = new ViewTaskManager(notifier);
        EditTaskManager editService = new EditTaskManager(notifier);
        
        System.out.println("\n=== Astronaut Daily Schedule Organizer ===\n");
        
        // Main menu loop (keeps running until user enters 0)
        int choice = -1;
        while (choice != 0) {
        	
        	// Print the menu options
	        System.out.println("\n========== MAIN MENU ==========");
	        System.out.println("1. Add a new task");
	        System.out.println("2. View all tasks");
	        System.out.println("3. View tasks by priority");
	        System.out.println("4. Remove a task");
	        System.out.println("5. Edit an existing task");
	        System.out.println("6. Mark task as completed");
	        System.out.println("0. Exit");
	        System.out.println("================================");
	        System.out.print("Enter your choice: ");
	        
	        // Read user choice
	        choice = sc.nextInt();
	        sc.nextLine(); // consume newline
	        
	        // Perform action based on choice
	        switch(choice) {
	        
	        case 1: // Add task
	        	System.out.print("Enter Task Name: ");
	        	String tName = sc.nextLine();
	        	System.out.print("Enter Start Time (HH:MM): ");
	        	String start = sc.nextLine();
	        	System.out.print("Enter End Time (HH:MM): ");
	        	String end = sc.nextLine();
	        	System.out.print("Enter Priority (High/Medium/Low): ");
	        	String priority = sc.nextLine();
	        	try {
	        		// Try to add task
	        		addService.addTask(tName, start, end, priority);
	        	} catch (TaskConflictException | InvalidTimeException e) {
	        		// Show error if time overlaps or time format invalid
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 2: // View all tasks
	        	try {
	        		viewService.viewTasks(); // display all tasks
	        	} catch (TaskNotFoundException e) {
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 3: // View tasks by priority
	        	System.out.print("Enter Priority (High/Medium/Low): ");
	        	String pr = sc.nextLine();
	        	try {
	        		viewService.viewTasks(pr); // show only tasks of given priority
	        	} catch (TaskNotFoundException e) {
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 4: // Remove task
	        	System.out.print("Enter Task Name to remove: ");
	        	String rem = sc.nextLine();
	        	try {
	        		removeService.removeTask(rem); // attempt to remove task
	        	} catch (TaskNotFoundException e) {
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 5: // Edit task
	        	System.out.print("Enter Existing Task Name: ");
	        	String oldName = sc.nextLine();
	        	System.out.print("Enter New Task Name: ");
	        	String newName = sc.nextLine();
	        	System.out.print("Enter Start Time (HH:MM): ");
	        	String st = sc.nextLine();
	        	System.out.print("Enter End Time (HH:MM): ");
	        	String et = sc.nextLine();
	        	System.out.print("Enter Priority (High/Medium/Low): ");
	        	String prio = sc.nextLine();
	        	try {
	        		// Attempt to edit task
	        		editService.editTask(oldName, newName, st, et, prio);
	        	} catch (TaskConflictException | InvalidTimeException e) {
	        		// Overlap or invalid time error
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 6: // Mark task as completed
	        	System.out.print("Enter Task Name to mark completed: ");
	        	String cmpl = sc.nextLine();
	        	try {
	        		markService.markTaskCompleted(cmpl);
	        	} catch (TaskNotFoundException e) {
	        		System.out.println("Error: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 0: // Exit program
	        	System.out.println("Exiting... Goodbye!");
	        	break;
	        	
	        default: // Invalid option
	        	System.out.println("Invalid choice, try again.");
	        }
        }
        
        // Close scanner to release resources
        sc.close();
    }
}
