# Exercise 2 – Satellite Command System

## Overview

In this exercise, I created a **Satellite Command System** in Java which simulates controlling a satellite in orbit.
The satellite can rotate in directions, activate/deactivate solar panels, collect data, and display its current status.

I applied **design patterns (Command + State)** to make the code modular and easy to extend.

---

## Features Implemented

1. **Initialize Satellite** – starts with:

   * Orientation = `North`
   * Solar Panels = `Inactive`
   * Data Collected = `0`

2. **Rotate Command** – changes orientation (`North`, `South`, `East`, `West`).

3. **Activate/Deactivate Panels** – controls whether solar panels are active.

4. **Collect Data** – collects 10 units per command **only if panels are active**.

5. **Status Command** – displays the current state of the satellite.

---

## Design Patterns Used

### 🔹 Command Pattern

* Each operation (rotate, activatePanels, deactivatePanels, collectData, status) is wrapped inside a **Command class**.
* This makes adding new commands very easy (e.g., `TransmitDataCommand`).

### 🔹 State Pattern

* The solar panels can be either **Active** or **Inactive**.
* Instead of writing if-else everywhere, I created two state classes:

  * `ActivePanelState`
  * `InactivePanelState`
* Each state decides how `collectData()` behaves.

---

##  Project Structure

##  How to Run

1. Go inside the `exercise2/satellite` folder.
2. Compile everything:

   ```sh
   javac SatelliteCommandSystem.java
   ```
3. Run the program:

   ```sh
   java exercise2.satellite.SatelliteCommandSystem
   ```
4. Use commands:

   ```
   rotate South
   activatePanels
   collectData
   status
   deactivatePanels
   collectData
   exit
   ```

---

## Sample Run

```
Satellite Command System Initialized. Type 'exit' to quit.
--- Satellite Status ---
  Orientation: North
  Solar Panels: Inactive
  Data Collected: 0
------------------------

Enter command > rotate South
Satellite orientation set to South.
--- Satellite Status ---
  Orientation: South
  Solar Panels: Inactive
  Data Collected: 0
------------------------

Enter command > activatePanels
Solar panels activated.
--- Satellite Status ---
  Orientation: South
  Solar Panels: Active
  Data Collected: 0
------------------------

Enter command > collectData
Data collected.
--- Satellite Status ---
  Orientation: South
  Solar Panels: Active
  Data Collected: 10
------------------------

Enter command > exit
Satellite Command System Shutting Down.
```

---
