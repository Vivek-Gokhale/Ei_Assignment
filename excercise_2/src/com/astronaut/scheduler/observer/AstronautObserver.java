package com.astronaut.scheduler.observer;

/**
 * Astronaut class that acts as an observer for all task-related activities
 * Each astronaut has a unique ID and name, and receives notifications about
 * add, delete, update, and mark complete operations
 */
public class AstronautObserver implements Observer {
    private String astronautId;
    private String astronautName;
    
    public AstronautObserver(String astronautId, String astronautName) {
        this.astronautId = astronautId;
        this.astronautName = astronautName;
    }
    
    @Override
    public void update(String message) {
        // Each astronaut receives and displays the notification with their identification
        System.out.println("[Astronaut " + astronautName + " (ID: " + astronautId + ") Notification] " + message);
    }
    
    public String getAstronautId() {
        return astronautId;
    }
    
    public void setAstronautId(String astronautId) {
        this.astronautId = astronautId;
    }
    
    public String getAstronautName() {
        return astronautName;
    }
    
    public void setAstronautName(String astronautName) {
        this.astronautName = astronautName;
    }
    
    @Override
    public String toString() {
        return "Astronaut [ID=" + astronautId + ", Name=" + astronautName + "]";
    }
}