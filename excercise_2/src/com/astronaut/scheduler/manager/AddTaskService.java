package com.astronaut.scheduler.manager;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.factory.TaskFactory;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeOverlap;

public class AddTaskService implements IAddService{
    private ScheduleManager manager = ScheduleManager.getInstance();
    private Subject notifier;
    private TaskFactory factory = new TaskFactory();

    public AddTaskService(Subject notifier) {
        this.notifier = notifier;
    }

    /**
     * Add a new task
     * 1. Create task using factory
     * 2. Check overlap with existing tasks
     * 3. If no overlap, add to TreeSet
     */
    public void addTask(String description, String start, String end, String priorityStr)
            throws InvalidTimeException, TaskConflictException {

        PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());
        Task newTask = factory.createTask(description, start, end, priority);

        TreeSet<Task> tasks = manager.getTasks();

        // Check for overlap
        for (Task t : tasks) {
            if (TimeOverlap.timesOverlap(t, newTask)) {
                notifier.notifyAllSubscriber("Error: overlap with " + t.getDescription());
                throw new TaskConflictException("Task Conflict Exception.");
            }
        }

        tasks.add(newTask);
        notifier.notifyAllSubscriber("Task added successfully: " + description);
    }

    
}