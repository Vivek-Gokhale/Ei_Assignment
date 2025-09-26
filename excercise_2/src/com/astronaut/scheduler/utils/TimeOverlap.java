package com.astronaut.scheduler.utils;

import com.astronaut.scheduler.model.Task;

public class TimeOverlap {
	public static boolean timesOverlap(Task t1, Task t2) {
        return !(t1.getEndTime().isBefore(t2.getStartTime()) 
                || t1.getStartTime().isAfter(t2.getEndTime()));
      }
}
