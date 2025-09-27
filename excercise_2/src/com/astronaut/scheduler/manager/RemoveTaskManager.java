package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;

public class RemoveTaskManager implements IRemoveTask{
    private ScheduleManager manager = ScheduleManager.getInstance();
    private Subject notifier;
    private static RemoveTaskManager instance;
    public RemoveTaskManager(Subject notifier) {
        this.notifier = notifier;
    }
    
    public static RemoveTaskManager getInstance(Subject notifier)
   	{
   		if(instance == null)
   		{
   			instance = new RemoveTaskManager(notifier);
   		}
   		return instance;
   		
   	}

    // remove task from tree set based on description as parameter
    public void removeTask(String description) throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();

        if (task.isPresent()) {
            tasks.remove(task.get());
            notifier.notifyAllSubscriber("Task removed successfully: " + description);
        } else {
            notifier.notifyAllSubscriber("Error: Task not found.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }
    }
}