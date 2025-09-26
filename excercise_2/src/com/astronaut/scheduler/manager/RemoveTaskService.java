package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;

public class RemoveTaskService implements IRemoveService{
    private final ScheduleManager manager = ScheduleManager.getInstance();
    private final Subject notifier;

    public RemoveTaskService(Subject notifier) {
        this.notifier = notifier;
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