package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.LoggerUtil;

public class MarkCompleteManager implements IMarkComplete {
    private ScheduleManager manager;
    private Subject notifier;
    private static MarkCompleteManager instance;

    public MarkCompleteManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance(); // get singleton schedule manager
    }

    public static MarkCompleteManager getInstance(Subject notifier) {
        if (instance == null) {
            // synchronize as multiple astronauts may access concurrently
            synchronized(MarkCompleteManager.class) {
                // double-check for safety
                if (instance == null) {
                    instance = new MarkCompleteManager(notifier);
                }
            }
        }
        return instance;
    }
    
    // mark a task as completed using its description
    public void markTaskCompleted(String description) throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();

        // find the task by description
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();

        if (task.isPresent()) {
            task.get().setIsCompleted(true); // mark as completed
            notifier.notifyAllSubscriber(description + " marked as completed."); // notify observers
        } else {
            // notify and log if task not found
            notifier.notifyAllSubscriber("Error: " + description + " Task not found.");
            LoggerUtil.log("Error: " + description + " Task not found.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }
    }
}
