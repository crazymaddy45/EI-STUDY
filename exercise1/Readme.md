# Exercise 1 – Design Patterns Implementation

## Overview

This project demonstrates **six fundamental design patterns** in Java, each implemented with a **unique real-world analogy**.
The goal is to understand how design patterns help in building scalable, maintainable, and reusable software systems.

---

## 🔹 Implemented Patterns

### 1. **Observer Pattern – Airtel Network**

* **Concept**: One change affects all observers.
* **Analogy**: If Airtel’s central server goes down, all Airtel SIM users are affected.
* **Code**: Implemented with `AirtelServer` (subject) and `AirtelUser` (observers).
* **Key Point**: Users (observers) automatically receive notifications when the server status changes.

---

### 2. **Strategy Pattern – Train Ticket Booking**

* **Concept**: Multiple strategies for the same task.
* **Analogy**: A person can book train tickets **online (UPI/Card)** or **offline (cash at counter)**.
* **Code**: Implemented with a `PaymentStrategy` interface, `OnlinePayment`, and `CashPayment` classes.
* **Key Point**: User can switch payment methods dynamically without changing booking logic.

---

### 3. **Singleton Pattern – Bank Server**

* **Concept**: Only one instance of a class exists globally.
* **Analogy**: Multiple bank accounts exist, but all transactions are processed by a **single central bank server**.
* **Code**: Implemented using a `BankServer` class with a private constructor and a `getInstance()` method.
* **Key Point**: Ensures only one server instance handles all transactions.

---

### 4. **Factory Pattern – Google Image Search**

* **Concept**: Factory creates objects based on user input.
* **Analogy**: Searching for images on Google → User enters “cat”, Google returns `CatImage` objects; enters “dog”, returns `DogImage`.
* **Code**: Implemented with an `ImageFactory` that creates different `Image` objects (`CatImage`, `DogImage`, etc.).
* **Key Point**: Client does not need to know how the images are created, only requests them.

---

### 5. **Decorator Pattern – App Locker**

* **Concept**: Dynamically add extra functionality without modifying the original class.
* **Analogy**: An **AppLocker** adds password protection to apps (Gallery, Notes) without changing the apps themselves.
* **Code**: Implemented with `App` (component), `GalleryApp`/`NotesApp` (concrete components), and `AppLocker` (decorator).
* **Key Point**: Base functionality remains intact; decorator adds security on top.

---

### 6. **Proxy Pattern – Clap to Switch on Fan**

* **Concept**: Proxy acts as a middleman controlling access to the real object.
* **Analogy**: Instead of manually turning on a fan with a switch, you **clap your hands** and a **clap sensor proxy** turns it on.
* **Code**: Implemented with `Fan` (subject), `RealFan` (real object), and `ClapProxy` (proxy).
* **Key Point**: User does not access the fan directly, only through the proxy.

---

## 🔹 Design Principles Used

* **SOLID Principles** → Clean, maintainable, extensible design.
* **Loose Coupling** → Each pattern decouples components.
* **Reusability** → Patterns can be reused in other projects.
* **Logging & Error Handling** → Incorporated wherever necessary.

---

## 🔹 How to Run

1. Navigate to the correct package folder.
2. Compile using:

   ```sh
   javac package_name/ClassName.java
   ```
3. Run using:

   ```sh
   java package_name.ClassName
   ```

---

## 🔹 Example Outputs

* **Observer** → "Airtel Server Down → All users notified"
* **Strategy** → "Booking successful using UPI" / "Booking successful with Cash"
* **Singleton** → "Transaction processed by BankServer instance"
* **Factory** → "Opening Cat Image: cat.png"
* **Decorator** → "Access Denied! Wrong Password ❌" / "Opening Gallery... Viewing Photos"
* **Proxy** → "👏 Clap detected! 🌀 Fan is now ON"

---
