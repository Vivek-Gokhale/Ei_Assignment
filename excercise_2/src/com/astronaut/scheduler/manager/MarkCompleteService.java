package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;

public class MarkCompleteService implements IMarkCompleteService{
    private final ScheduleManager manager = ScheduleManager.getInstance();
    private final Subject notifier;

    public MarkCompleteService(Subject notifier) {
        this.notifier = notifier;
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
