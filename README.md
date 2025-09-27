# Exercise 1 - Implementation of Design Patterns

## 1. Behavioral Design Patterns

### 1.1 **Observer Design Pattern**
- **Use Case:** YouTube subscription system  
- **Description:**  
  - Users act as **observers** and the channel acts as the **subject**.  
  - A user can **subscribe** or **unsubscribe** from a channel.  
  - The channel can **broadcast notifications** to all subscribed users.  
  - Observers (users) continuously watch for events and receive updates when the channel posts something new.  

---

### 1.2 **Command Design Pattern**
- **Use Case:** Chess game commands  
- **Description:**  
  - Simulated two commands: **Move** and **Castle**.  
  - A user can move any chess piece from one cell to another on the board.  
  - Supports both **execute** and **undo** operations.  

---

## 2. Structural Design Patterns

### 2.1 **Composite Design Pattern**
- **Use Case:** DNS (Domain Name System) hierarchy  
- **Description:**  
  - Each domain name acts as a **component**.  
  - Host records and subdomains are arranged in a **hierarchical structure**.  
  - Composite pattern allows treating individual domain records and groups of records uniformly.  

---

### 2.2 **Adapter Design Pattern**
- **Use Case:** Payment Gateway integration  
- **Description:**  
  - A user needs to make a payment using **Stripe**, but the system is only compatible with **PayPal**.  
  - Created a **Stripe Payment Adapter** to make Stripe transactions compatible with the system.  

---

## 3. Creational Design Patterns

### 3.1 **Singleton Design Pattern**
- **Use Case:** Database connection management  
- **Description:**  
  - Prevents creating multiple objects of the database connection.  
  - Ensures only **one instance** of the connection exists.  
  - Implemented thread-safe logic to handle **multithreading scenarios** safely.  

---

### 3.2 **Builder Design Pattern**
- **Use Case:** Smart Home automation system  
- **Description:**  
  - Used builder to create different representations of a **Smart Home object** with various configurations.  
  - Example:  
    - **Basic Setting** – Minimal features enabled.  
    - **Luxury Setting** – Advanced features enabled.  

---

# Exercise 2 - Instructions

## Problem Statement 1 - Astronaut Daily Schedule Organizer

### Features Implemented
1. Add a new task with description, start time, end time, and priority level.
2. Remove an existing task.
3. View all tasks sorted by start time.
4. Validate that new tasks do not overlap with existing tasks.
5. Provide appropriate error messages for invalid operations.
6. Edit an existing task.
7. Mark tasks as completed.
8. View tasks for a specific priority level.
9. Implemented logging mechanism to log different event statuses into a scheduler log file.
10. Exception handling with custom exceptions such as:
   - `InvalidTimeException`
   - `TaskConflictException`
   - `TaskNotFoundException`

---

## Project Structure

excericse_2
├── src
│ ├── com.astronaut
│ │ └── Main.java
│ │ → Entry point for running the project.
│ │ Simulates different operations: add, delete, edit, mark complete, and view tasks,
│ │ including positive and negative test cases.
│ │
│ ├── com.astronaut.scheduler.exception
│ │ ├── InvalidTimeException.java
│ │ │ → Handles invalid time formats (random string or end time before start time).
│ │ ├── TaskConflictException.java
│ │ │ → Handles situations where task time ranges overlap.
│ │ └── TaskNotFoundException.java
│ │ → Handles cases where a task is not found during remove, view, or edit operations.
│ │
│ ├── com.astronaut.scheduler.factory
│ │ └── TaskFactory.java
│ │ → Implements Factory Design Pattern to hide task object creation logic from the client.
│ │
│ ├── com.astronaut.scheduler.manager
│ │ ├── ScheduleManager.java
│ │ │ → Implements Singleton Pattern to ensure only one instance exists.
│ │ ├── AddTaskService.java
│ │ │ → Service class for adding tasks (adheres to SRP - Single Responsibility Principle).
│ │ ├── EditTaskService.java
│ │ │ → Service class for editing tasks.
│ │ ├── ViewTaskService.java
│ │ │ → Service class for viewing tasks.
│ │ ├── RemoveTaskService.java
│ │ │ → Service class for removing tasks.
│ │ ├── MarkCompletedService.java
│ │ │ → Service class for marking tasks as completed.
│ │ ├── IAddService.java
│ │ │ → Interface with add() method, implemented by AddTaskService.
│ │ │ (adheres to OCP - Open/Closed Principle and ISP - Interface Segregation Principle).
│ │ ├── IRemoveService.java
│ │ │ → Interface for removing tasks.
│ │ ├── ITaskView.java
│ │ │ → Interface for viewing tasks, extends IViewTaskByPriority.
│ │ ├── IViewTaskByPriority.java
│ │ │ → Interface for viewing tasks by priority, implemented in ViewTaskByPriority.
│ │ └── IMarkCompletedService.java
│ │ → Interface for marking tasks as completed.
│ │
│ ├── com.astronaut.scheduler.model
│ │ └── Task.java
│ │ → Model class with fields like description, start time, end time, priority, etc.
│ │ Includes getters, setters, and utility methods.
│ │
│ ├── com.astronaut.scheduler.observer
│ │ ├── ConsoleObserver.java
│ │ │ → Observer implementation that displays updates in the console.
│ │ ├── FileLoggerObserver.java
│ │ │ → Observer implementation that logs updates into a file.
│ │ ├── Notifier.java
│ │ │ → Maintains subscribers and notifies them on events.
│ │ ├── Observer.java
│ │ │ → Observer interface with update() method.
│ │ └── Subject.java
│ │ → Subject interface with methods to subscribe, unsubscribe, and notify observers.
│ │
│ └── com.astronaut.scheduler.utils
│ ├── LoggerUtil.java
│ │ → Utility class used by FileLoggerObserver to log status messages.
│ ├── PriorityLevel.java
│ │ → Enum with predefined values (HIGH, MEDIUM, LOW) to constrain user input.
│ └── TimeValidator.java
│ → Utility class to validate whether time formats are correct.
