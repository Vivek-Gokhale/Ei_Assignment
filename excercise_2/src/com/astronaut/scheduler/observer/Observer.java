package com.astronaut.scheduler.observer;

//Observer interface for receiving notifications when a task-related event occurs
public interface Observer {
	void update(String message);
}
