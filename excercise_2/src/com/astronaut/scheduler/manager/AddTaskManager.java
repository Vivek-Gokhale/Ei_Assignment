package com.astronaut.scheduler.manager;
import java.util.TreeSet;

import com.astronaut.scheduler.exception.InvalidTimeException;
import com.astronaut.scheduler.exception.TaskConflictException;
import com.astronaut.scheduler.factory.TaskFactory;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.PriorityLevel;
import com.astronaut.scheduler.utils.TimeOverlap;

public class AddTaskManager implements IAddTask{
    private ScheduleManager manager = ScheduleManager.getInstance();
    private Subject notifier;
    private TaskFactory factory = new TaskFactory();
    private static AddTaskManager instance;
    public AddTaskManager(Subject notifier) {
        this.notifier = notifier;
    }
    
    public static AddTaskManager getInstance(Subject notifier)
	{
		if(instance == null)
		{
			instance = new AddTaskManager(notifier);
		}
		return instance;
		
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