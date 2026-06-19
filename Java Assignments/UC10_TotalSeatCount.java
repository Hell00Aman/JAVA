// UC10: Count Total Seats using Stream API (map + reduce)
// This program calculates total seating capacity of train bogies

import java.util.*;

// Reusing Bogie class
class Bogie {
    String name;
    int capacity;
    String type;

    Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
}

public class UC10_TotalSeatCount {

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 56, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));
        bogies.add(new Bogie("Cargo Rectangular", 100, "Goods")); // can be ignored logically

        // Step 2: Convert to stream, extract capacity, and sum using reduce()
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)           // extract capacity
                .reduce(0, Integer::sum);       // aggregate

        // Step 3: Display total seating capacity
        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        // Note:
        // reduce() combines all values into a single result
        // identity value 0 ensures correct result for empty list
    }
}
