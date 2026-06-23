// UC14: Custom Exception for Invalid Bogie Capacity

import java.util.*;

// Step 1: Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie Class with Validation
class PassengerBogie {
    String type;
    int capacity;

    // Constructor with validation
    PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " Bogie with capacity: " + capacity;
    }
}

// Step 3: Main Application
public class UC14_InvalidCapacityException {
    public static void main(String[] args) {

        List<PassengerBogie> train = new ArrayList<>();

        // Valid Bogie
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            train.add(b1);
            System.out.println("Added: " + b1);
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        // Invalid Bogie (Negative Capacity)
        try {
            PassengerBogie b2 = new PassengerBogie("AC Chair", -10);
            train.add(b2);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid Bogie (Zero Capacity)
        try {
            PassengerBogie b3 = new PassengerBogie("First Class", 0);
            train.add(b3);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Final Train Composition
        System.out.println("\nFinal Train Consist:");
        for (PassengerBogie b : train) {
            System.out.println(b);
        }
    }
}
