import java.util.*;

// Class to store vehicle details
class ParkingSlot {
    String licensePlate;
    long entryTime;

    ParkingSlot(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = System.currentTimeMillis();
    }
}

// Main class
public class ParkingLotOpenAddressing {

    private static final int SIZE = 500; // total parking spots
    private ParkingSlot[] table = new ParkingSlot[SIZE];

    // Hash function based on license plate
    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Park vehicle using linear probing
    public boolean park(String licensePlate) {
        int index = hash(licensePlate);

        // Linear probing for collision resolution
        for (int i = 0; i < SIZE; i++) {
            int probeIndex = (index + i) % SIZE;

            if (table[probeIndex] == null) {
                table[probeIndex] = new ParkingSlot(licensePlate);
                System.out.println("Parked at spot: " + probeIndex);
                return true;
            }
        }
        System.out.println("Parking Full!");
        return false;
    }

    // Remove vehicle and calculate time
    public void exit(String licensePlate) {
        int index = hash(licensePlate);

        for (int i = 0; i < SIZE; i++) {
            int probeIndex = (index + i) % SIZE;

            if (table[probeIndex] != null &&
                table[probeIndex].licensePlate.equals(licensePlate)) {

                long exitTime = System.currentTimeMillis();
                long duration = (exitTime - table[probeIndex].entryTime) / 1000;

                System.out.println("Vehicle exited. Time parked: " + duration + " sec");

                table[probeIndex] = null; // free slot
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    // Find nearest available spot (from entrance = index 0)
    public int nearestAvailable() {
        for (int i = 0; i < SIZE; i++) {
            if (table[i] == null) return i;
        }
        return -1;
    }

    // Calculate occupancy
    public void stats() {
        int occupied = 0;

        for (ParkingSlot slot : table) {
            if (slot != null) occupied++;
        }

        double loadFactor = (double) occupied / SIZE;

        System.out.println("Occupied spots: " + occupied);
        System.out.println("Load factor: " + loadFactor);
    }

    public static void main(String[] args) {

        ParkingLotOpenAddressing lot = new ParkingLotOpenAddressing();

        // Simulate parking
        lot.park("TN01AB1234");
        lot.park("TN02CD5678");
        lot.park("TN03EF9999");

        // Check nearest spot
        System.out.println("Nearest available spot: " + lot.nearestAvailable());

        // Exit vehicle
        lot.exit("TN01AB1234");

        // Show stats
        lot.stats();
    }
}
