package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.LoggerUtil;

public class RemoveTaskManager implements IRemoveTask {
    private ScheduleManager manager;
    private Subject notifier;
    private static RemoveTaskManager instance;

    public RemoveTaskManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance(); // get singleton schedule manager
    }
    
    public static RemoveTaskManager getInstance(Subject notifier) {
        if(instance == null) {
            // synchronize as multiple astronauts may access concurrently
            synchronized(RemoveTaskManager.class) {
                // double-check for safety
                if(instance == null) {
                    instance = new RemoveTaskManager(notifier);
                }
            }
        }
        return instance;
    }

    // remove a task using its description
    public void removeTask(String description) throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();

        // find the task by description
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();

        if (task.isPresent()) {
            tasks.remove(task.get()); // remove task
            notifier.notifyAllSubscriber("Task removed successfully: " + description); // notify observers
        } else {
            // notify and log if task not found
            notifier.notifyAllSubscriber("Error: Task not found.");
            LoggerUtil.log("Error: "+ description +" Task not found.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }
    }
}
