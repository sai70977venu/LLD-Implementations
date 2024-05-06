#  **Functional Requirements**
 
**Parking Lot** 
1. Create the parking lot. 
2. Add floors to the parking lot. 
3. Add a parking lot slot to any of the floors. 
4. Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket. 
5. Unpark a vehicle given the ticket id. 
6. Displays the number of free slots per floor for a specific vehicle type. 
7. Displays all the free slots per floor for a specific vehicle type. 
8. Displays all the occupied slots per floor for a specific vehicle type.

**Vehicles**

1. Every vehicle will have a type, registration number, and color.
2. Different Types of Vehicles:
   * Car
   * Bike
   * Truck

**Parking Slots**

1. Each type of slot can park a specific type of vehicle.
2. No other vehicle should be allowed by the system.
3. Finding the first available slot should be based on:
   * The slot should be of the same type as the vehicle.
   * The slot should be on the lowest possible floor in the parking lot.
   * The slot should have the lowest possible slot number on the floor.
4. Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.

**Parking Lot Floors**

1. Numbered serially from 1 to n where n is the number of floors.
2. Might contain one or more parking lot slots of different types.
3. We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.

**Tickets**

1. The ticket id would be of the following format: <parking_lot_id>_<floor_no>_<slot_no>. 
    Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)