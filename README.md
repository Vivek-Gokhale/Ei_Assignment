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
