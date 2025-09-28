package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.factory.TaskFactory;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeOverlap;

public class EditTaskManager implements IEditTask{
    private ScheduleManager manager;
    private Subject notifier;
    private TaskFactory factory;
    private static EditTaskManager instance;
    public EditTaskManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance();
        factory = new TaskFactory();
    }
    
    
    public static EditTaskManager getInstance(Subject notifier)
   	{
   		if(instance == null)
   		{
   			instance = new EditTaskManager(notifier);
   		}
   		return instance;
   		
   	}

    /**
     * Edit an existing task by target description
     * 1. Find existing task
     * 2. Remove it
     * 3. Create new task with updated details
     * 4. Check overlap → if overlap, restore original
     * 5. If no overlap, insert updated task
     */
    public void editTask(String descriptionTarget, String newDescription, 
                         String start, String end, String priorityStr)
            throws InvalidTimeException, TaskConflictException {

        TreeSet<Task> tasks = manager.getTasks();

        Optional<Task> existing = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(descriptionTarget))
                .findFirst();

        if (!existing.isPresent()) {
            notifier.notifyAllSubscriber("Error: Task not found for editing.");
            throw new TaskConflictException("Task not found to edit.");
        }

        Task original = existing.get();
        tasks.remove(original);

        PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());
        Task newTask = factory.createTask(newDescription, start, end, priority);

        // Check overlap
        for (Task t : tasks) {
            if (TimeOverlap.timesOverlap(t, newTask)) {
                tasks.add(original); // restore old task
                notifier.notifyAllSubscriber("Error: overlap with " + t.getDescription());
                throw new TaskConflictException("Task Conflict Exception.");
            }
        }

        tasks.add(newTask);
        notifier.notifyAllSubscriber("Task updated successfully: " + newDescription);
    }
}