package com.astronaut.scheduler.observer;



// ConsoleObserver is one observer which implement behavior of observer
public class ConsoleObserver implements Observer{

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		System.out.println("[Observer Alert] " + message);
	}

}
