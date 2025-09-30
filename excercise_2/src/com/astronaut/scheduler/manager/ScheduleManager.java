package com.astronaut.scheduler.manager;

import java.util.Comparator;
import java.util.TreeSet;

import com.astronaut.scheduler.model.Task;

// singleton class to manage all scheduled tasks
// ensures only one instance manages the task collection
public class ScheduleManager {
    private static ScheduleManager instance;
    private TreeSet<Task> tasks; // store tasks sorted by start time

    private ScheduleManager() {
        // TreeSet with comparator to keep tasks sorted by start time
        tasks = new TreeSet<>(Comparator.comparing(Task::getStartTime));
    }

    // get singleton instance of ScheduleManager
    public static ScheduleManager getInstance() {
        if (instance == null) {
            // synchronize for thread safety
            synchronized (ScheduleManager.class) {
                // double-check for safety
                if (instance == null) {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    // return all tasks
    public TreeSet<Task> getTasks() {
        return tasks;
    }
}
