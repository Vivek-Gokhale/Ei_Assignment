package com.astronaut.scheduler.observer;

import com.astronaut.scheduler.utils.LoggerUtil;

public class FileLoggerObserver implements Observer{

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		LoggerUtil.log(message);
		
	}

}
