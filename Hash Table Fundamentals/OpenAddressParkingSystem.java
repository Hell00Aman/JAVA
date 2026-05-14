import java.util.*;

// Class to represent a parking slot
class ParkingSlot {
    String licensePlate;
    long entryTime;
    boolean isOccupied;

    public ParkingSlot() {
        this.licensePlate = null;
        this.entryTime = 0;
        this.isOccupied = false;
    }
}

// Main Parking System
public class OpenAddressParkingSystem {

    private ParkingSlot[] table;
    private int capacity;
    private int size;
    private int totalProbes;

    public OpenAddressParkingSystem(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.totalProbes = 0;

        table = new ParkingSlot[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ParkingSlot();
        }
    }

    // Hash function: license plate → index
    private int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % capacity;
    }

    // Park vehicle using linear probing
    public String parkVehicle(String licensePlate) {

        int index = hash(licensePlate);
        int probes = 0;

        // Linear probing
        while (table[index].isOccupied) {
            index = (index + 1) % capacity;
            probes++;
        }

        // Assign slot
        table[index].licensePlate = licensePlate;
        table[index].entryTime = System.currentTimeMillis();
        table[index].isOccupied = true;

        size++;
        totalProbes += probes;

        return "Assigned spot #" + index + " (" + probes + " probes)";
    }

    // Exit vehicle and calculate fee
    public String exitVehicle(String licensePlate) {

        int index = hash(licensePlate);

        // Search using probing
        while (table[index].isOccupied) {

            if (licensePlate.equals(table[index].licensePlate)) {

                long durationMillis = System.currentTimeMillis() - table[index].entryTime;
                double hours = durationMillis / (1000.0 * 60 * 60);

                double fee = hours * 5; // $5 per hour

                table[index].isOccupied = false;
                table[index].licensePlate = null;

                size--;

                return "Spot #" + index + " freed, Duration: " +
                        String.format("%.2f", hours) + " hrs, Fee: $" +
                        String.format("%.2f", fee);
            }

            index = (index + 1) % capacity;
        }

        return "Vehicle not found!";
    }

    // Get parking statistics
    public String getStatistics() {

        double occupancy = (size * 100.0) / capacity;
        double avgProbes = size == 0 ? 0 : (double) totalProbes / size;

        return "Occupancy: " + String.format("%.2f", occupancy) +
                "%, Avg Probes: " + String.format("%.2f", avgProbes);
    }

    // Main method for testing
    public static void main(String[] args) throws InterruptedException {

        OpenAddressParkingSystem system = new OpenAddressParkingSystem(10);

        System.out.println(system.parkVehicle("ABC-1234"));
        System.out.println(system.parkVehicle("ABC-1235"));
        System.out.println(system.parkVehicle("XYZ-9999"));

        Thread.sleep(2000); // simulate time

        System.out.println(system.exitVehicle("ABC-1234"));

        System.out.println(system.getStatistics());
    }
}
