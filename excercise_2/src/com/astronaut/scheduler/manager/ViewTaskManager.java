package com.astronaut.scheduler.manager;

import java.util.TreeSet;

import com.astronaut.scheduler.exception.TaskNotFoundException;
import com.astronaut.scheduler.model.Task;
import com.astronaut.scheduler.observer.Subject;
import com.astronaut.scheduler.utils.PriorityLevel;

public class ViewTaskManager implements ITaskView{
    private ScheduleManager manager;
    private Subject notifier;
    private static ViewTaskManager instance;
    public ViewTaskManager(Subject notifier) {
        this.notifier = notifier;
        manager = ScheduleManager.getInstance();
    }
    
    public static ViewTaskManager getInstance(Subject notifier)
   	{
   		if(instance == null)
   		{
   			instance = new ViewTaskManager(notifier);
   		}
   		return instance;
   		
   	}

    // compile time polymorphism - method overloading
 	// view task which are currently stored in tree set
    public void viewTasks() throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            notifier.notifyAllSubscriber("No tasks scheduled.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }
        int i = 1;
        for (Task t : tasks) {
            System.out.println(i + ". " + t);
            i++;
        }
    }

    // view task based on priority 
    public void viewTasks(String priorityStr) throws TaskNotFoundException {
        TreeSet<Task> tasks = manager.getTasks();
        PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());

        if (tasks.isEmpty()) {
            notifier.notifyAllSubscriber("No tasks scheduled.");
            throw new TaskNotFoundException("Task Not Found Exception.");
        }

        int i = 1;
        for (Task t : tasks) {
            if (t.getPriority() == priority) {
                System.out.println(i + ". " + t);
                i++;
            }
        }
    }
}