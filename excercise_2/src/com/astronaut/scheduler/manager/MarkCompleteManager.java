package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;

public class MarkCompleteManager implements IMarkComplete{
    private ScheduleManager manager = ScheduleManager.getInstance();
    private Subject notifier;
    private static MarkCompleteManager instance;
    public MarkCompleteManager(Subject notifier) {
        this.notifier = notifier;
    }

    public static MarkCompleteManager getInstance(Subject notifier)
   	{
   		if(instance == null)
   		{
   			instance = new MarkCompleteManager(notifier);
   		}
   		return instance;
   		
   	}
    
 // mark task as completed based on description
    public void markTaskCompleted(String description) throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();

        if (task.isPresent()) {
            task.get().setIsCompleted(true);
            notifier.notifyAllSubscriber(description + " marked as completed.");
        } else {
            notifier.notifyAllSubscriber("Error: Task not found.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }
    }
}
