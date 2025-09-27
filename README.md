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


  ## Design Principles, Data Structure and Patterns Applied

### SOLID Principles
- **S (Single Responsibility Principle):**  
  Each service class (Add, Edit, Remove, MarkCompleted, View) has a single responsibility.  

- **O (Open/Closed Principle):**  
  New services or observers can be added without modifying existing code.  

- **L (Liskov Substitution Principle):**  
  Observers (ConsoleObserver, FileLoggerObserver) can be swapped without breaking the system.  

- **I (Interface Segregation Principle):**  
  Interfaces are small and purpose-specific (e.g., `IAddService`, `IRemoveService`, `ITaskView`).  

- **D (Dependency Inversion Principle):**  
  Services depend on abstractions (`Subject`, `Observer`) rather than concrete implementations.  

---

### Data Structures
- **TreeSet:**  
  used treeset data stucture is balanced binary search tree usefull when view operation perfomed show task in sorted format.

---

### Design Patterns
- **Singleton Pattern:**  
  `ScheduleManager` ensures only one global instance exists.  

- **Factory Pattern:**  
  `TaskFactory` centralizes task creation and hides object construction details.  

- **Observer Pattern:**  
  `ConsoleObserver` and `FileLoggerObserver` are notified about task events, enabling flexible logging and monitoring.  


## Project Structure

### Root Folder: `excericse_2`
- **JRE System Library [JavaSE-21]**  
  Standard Java runtime environment.

- **src** (source folder)  
  Contains all project packages and classes.

---

### Package: `com.astronaut`
- **Main.java**  
  Entry point for running the project.  
  Simulates different operations: add, delete, edit, mark complete, and view tasks.  
  Includes both positive and negative test cases.

---

### Package: `com.astronaut.scheduler.exception`
- **InvalidTimeException.java**  
  Handles invalid time formats (e.g., random strings, or when end time is before start time).  

- **TaskConflictException.java**  
  Handles conflicts when two tasks overlap in their time ranges.  

- **TaskNotFoundException.java**  
  Handles cases where a task is not found during remove, view, or edit operations.  

---

### Package: `com.astronaut.scheduler.factory`
- **TaskFactory.java**  
  Implements the **Factory Design Pattern** to hide task object creation logic from the client.  

---

### Package: `com.astronaut.scheduler.manager`
- **ScheduleManager.java**  
  Implements the **Singleton Pattern** to ensure only one instance of the schedule manager exists.  

- **AddTaskService.java**  
  Service class for adding tasks (**SRP - Single Responsibility Principle**).  

- **EditTaskService.java**  
  Service class for editing tasks.  

- **ViewTaskService.java**  
  Service class for viewing tasks.  

- **RemoveTaskService.java**  
  Service class for removing tasks.  

- **MarkCompletedService.java**  
  Service class for marking tasks as completed.  

- **IAddService.java**  
  Interface with `add()` method, implemented by `AddTaskService`.  
  Adheres to **OCP (Open/Closed Principle)** and **ISP (Interface Segregation Principle)**.  

- **IRemoveService.java**  
  Interface for removing tasks.  

- **ITaskView.java**  
  Interface for viewing tasks, extends `IViewTaskByPriority`.  

- **IViewTaskByPriority.java**  
  Interface for viewing tasks by priority.  

- **IMarkCompletedService.java**  
  Interface for marking tasks as completed.  

---

### Package: `com.astronaut.scheduler.model`
- **Task.java**  
  Model class containing fields: description, start time, end time, priority, and status.  
  Includes getters, setters, and utility methods.  

---

### Package: `com.astronaut.scheduler.observer`
- **ConsoleObserver.java**  
  Implementation of the **Observer Pattern**, logs notifications to the console.  

- **FileLoggerObserver.java**  
  Implementation of the **Observer Pattern**, logs notifications to a file.  

- **Notifier.java**  
  Maintains a list of observers and provides subscribe, unsubscribe, and notify methods.  

- **Observer.java**  
  Observer interface with an `update()` method.  

- **Subject.java**  
  Subject interface with methods to subscribe, unsubscribe, and notify observers.  

---

### Package: `com.astronaut.scheduler.utils`
- **LoggerUtil.java**  
  Utility class used by `FileLoggerObserver` to log status messages.  

- **PriorityLevel.java**  
  Enum with predefined values (**HIGH, MEDIUM, LOW**) to constrain user input.  

- **TimeValidator.java**  
  Utility class to check whether time values are valid.

