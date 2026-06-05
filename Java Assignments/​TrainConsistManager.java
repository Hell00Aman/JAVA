import java.util.ArrayList;

/**
 * Represents a passenger bogie with capacity tracking.
 */
class PassengerBogie {
    private String bogieId;
    private String type; // Sleeper, AC Chair, First Class
    private int seatCapacity;

    public PassengerBogie(String bogieId, String type, int seatCapacity) {
        this.bogieId = bogieId;
        this.type = type;
        this.seatCapacity = seatCapacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId + " | Type: " + type + " | Capacity: " + seatCapacity;
    }
}

/**
 * Manages the train consist composition dynamically using ArrayList operations.
 */
public class TrainConsistManager {
    // Dynamic list to manage train consist
    private ArrayList<PassengerBogie> consistList = new ArrayList<>();

    // UC2: Dynamic insertion operation
    public void addBogie(PassengerBogie bogie) {
        consistList.add(bogie);
        System.out.println("Successfully attached: " + bogie.getBogieId());
    }

    // UC2: Dynamic removal operation
    public boolean removeBogie(String bogieId) {
        for (PassengerBogie bogie : consistList) {
            if (bogie.getBogieId().equalsIgnoreCase(bogieId)) {
                consistList.remove(bogie);
                System.out.println("Successfully removed: " + bogieId);
                return true;
            }
        }
        System.out.println("Error: Bogie " + bogieId + " not found in current consist.");
        return false;
    }

    // UC2: Inspect and search operation
    public boolean containsBogie(String bogieId) {
        for (PassengerBogie bogie : consistList) {
            if (bogie.getBogieId().equalsIgnoreCase(bogieId)) {
                return true;
            }
        }
        return false;
    }

    // Displays the current structure of the train
    public void displayConsist() {
        System.out.println("\n--- Current Train Consist ---");
        if (consistList.isEmpty()) {
            System.out.println("[Engine] -> (No bogies attached)");
        } else {
            System.out.print("[Engine]");
            for (PassengerBogie bogie : consistList) {
                System.out.print(" -> [" + bogie.getBogieId() + "]");
            }
            System.out.println();
        }
        System.out.println("-----------------------------\n");
    }

    public static void main(String[] args) {
        TrainConsistManager app = new TrainConsistManager();

        System.out.println("--- Scenario Start: Building the Train ---");
        // Dynamically adding passenger bogies
        app.addBogie(new PassengerBogie("SL-01", "Sleeper", 72));
        app.addBogie(new PassengerBogie("AC-01", "AC Chair", 56));
        app.addBogie(new PassengerBogie("FC-01", "First Class", 24));
        app.displayConsist();

        // Testing dynamic inspection
        System.out.println("Checking if AC-01 exists: " + app.containsBogie("AC-01"));

        // Testing dynamic removal
        System.out.println("\n--- Scenario Update: Detaching Bogie ---");
        app.removeBogie("AC-01");
        app.displayConsist();

        System.out.println("Checking if AC-01 exists now: " + app.containsBogie("AC-01"));
    }
}
