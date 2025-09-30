package com.astronaut.scheduler.manager;

import java.util.Optional;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.factory.TaskFactory;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.LoggerUtil;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeOverlap;

public class EditTaskManager implements IEditTask {
    private ScheduleManager manager;
    private Subject notifier;
    private TaskFactory factory;
    private static EditTaskManager instance;

    public EditTaskManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance();
        factory = new TaskFactory();
    }

    public static EditTaskManager getInstance(Subject notifier) {
        if (instance == null) {
            // synchronization as multiple astronauts may edit at the same time
            synchronized (EditTaskManager.class) {
                // double check for safety
                if (instance == null) {
                    instance = new EditTaskManager(notifier);
                }
            }
        }
        return instance;
    }

    public void editTask(String descriptionTarget, String newDescription, 
                         String start, String end, String priorityStr)
            throws InvalidTimeException, TaskConflictException {

        TreeSet<Task> tasks = manager.getTasks();

        // find existing task by description
        Optional<Task> existing = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(descriptionTarget))
                .findFirst();

        if (!existing.isPresent()) {
            notifier.notifyAllSubscriber("Error: Task not found for editing.");
            throw new TaskConflictException("Task not found to edit.");
        }

        Task original = existing.get();
        tasks.remove(original); // remove old task

        // create updated task
        PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());
        Task newTask = factory.createTask(newDescription, start, end, priority);

        // check for overlap with other tasks
        for (Task t : tasks) {
            if (TimeOverlap.timesOverlap(t, newTask)) {
                tasks.add(original); // restore original if conflict
                notifier.notifyAllSubscriber("Error: " + newTask.getDescription() + " overlaps with " + t.getDescription());
                LoggerUtil.log("Error: " + newTask.getDescription() + " overlaps with " + t.getDescription());
                throw new TaskConflictException("Task Conflict Exception.");
            }
        }

        tasks.add(newTask); // add updated task
        notifier.notifyAllSubscriber("Task updated successfully: " + newDescription);
    }
}
