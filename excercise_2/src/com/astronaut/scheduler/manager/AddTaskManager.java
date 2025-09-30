package com.astronaut.scheduler.manager;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.factory.TaskFactory;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.LoggerUtil;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeOverlap;

public class AddTaskManager implements IAddTask {
    private ScheduleManager manager;
    private Subject notifier;
    private TaskFactory factory;
    private static AddTaskManager instance;

    public AddTaskManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance();
        factory = new TaskFactory();
    }
    
    public static AddTaskManager getInstance(Subject notifier) {
        if (instance == null) {
            // synchronize as multiple astronauts might use app at once
            synchronized (AddTaskManager.class) {
                // double-check for thread safety
                if (instance == null) {
                    instance = new AddTaskManager(notifier);
                }
            }
        }
        return instance;
    }

    public void addTask(String description, String start, String end, String priorityStr)
            throws InvalidTimeException, TaskConflictException {

        // convert string to enum priority
        PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());

        // create new task using factory
        Task newTask = factory.createTask(description, start, end, priority);

        // get existing tasks from schedule
        TreeSet<Task> tasks = manager.getTasks();

        // check for overlap with already scheduled tasks
        for (Task t : tasks) {
            if (TimeOverlap.timesOverlap(t, newTask)) {
                // notify and log conflict
                notifier.notifyAllSubscriber("Error: " + newTask.getDescription() + " overlaps with " + t.getDescription());
                LoggerUtil.log("Error: " + newTask.getDescription() + " overlaps with " + t.getDescription());
                throw new TaskConflictException("Task Conflict Exception.");
            }
        }

        // add task if no overlap found
        tasks.add(newTask);

        // notify success
        notifier.notifyAllSubscriber("Task added successfully: " + description);
    }
}
