package com.astronaut.scheduler.observer;

import java.util.ArrayList;

//Notifier is one Subject which implement behavior of Subject
public class Notifier implements Subject{
	
	private final ArrayList<Observer> observers = new ArrayList<>();
	
	
	// subscribe method to add new observer to array list
	@Override
	public void subscribe(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	// unsubscribe method to remove observer from array list
	@Override
	public void unsubscribe(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
		
	}

	
	// method to notify all observer about an event or notification
	@Override
	public void notifyAllSubscriber(String message) {
		// TODO Auto-generated method stub
		for(Observer o : observers)
		{
			o.update(message);
		}
		
	}

}
