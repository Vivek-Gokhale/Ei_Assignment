package com.astronaut.scheduler.observer;


//Subject interface defines methods to manage observers and notify them of events
public interface Subject {
	void subscribe(Observer observer);
	void unsubscribe(Observer observer);
	void notifyAllSubscriber(String message);
}
