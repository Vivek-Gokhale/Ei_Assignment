package com.astronaut.scheduler.utils;

import com.astronaut.scheduler.model.Task;

// check is two time stamp is conflicting with each other or not
public class TimeOverlap {
	//return true if conflict else false
	public static boolean timesOverlap(Task t1, Task t2) {
        return !(t1.getEndTime().isBefore(t2.getStartTime()) 
                || t1.getStartTime().isAfter(t2.getEndTime()));
      }
}
