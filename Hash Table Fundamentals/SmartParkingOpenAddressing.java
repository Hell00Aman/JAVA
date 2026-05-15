import java.util.*;

// Slot status enum
enum Status {
    EMPTY, OCCUPIED, DELETED
}

// Parking slot structure
class ParkingSlot {
    String licensePlate;
    long entryTime;
    Status status;

    public ParkingSlot() {
        status = Status.EMPTY;
    }
}

// Main Parking System
public class SmartParkingOpenAddressing {

    private ParkingSlot[] table;
    private int capacity;
    private int size;
    private int totalProbes;

    // Track hourly usage (0–23 hours)
    private int[] hourlyUsage;

    public SmartParkingOpenAddressing(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.totalProbes = 0;

        table = new ParkingSlot[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ParkingSlot();
        }

        hourlyUsage = new int[24];
    }

    // Hash function
    private int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % capacity;
    }

    // Find nearest available spot (linear probing)
    private int findSlot(String licensePlate) {
        int index = hash(licensePlate);
        int probes = 0;

        while (table[index].status == Status.OCCUPIED) {
            index = (index + 1) % capacity;
            probes++;
        }

        totalProbes += probes;
        return index;
    }

    // Park vehicle
    public String parkVehicle(String licensePlate) {

        if (size == capacity) {
            return "Parking Full!";
        }

        int index = findSlot(licensePlate);

        table[index].licensePlate = licensePlate;
        table[index].entryTime = System.currentTimeMillis();
        table[index].status = Status.OCCUPIED;

        size++;

        // Track peak hour
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        hourlyUsage[hour]++;

        return "Vehicle parked at spot #" + index;
    }

    // Exit vehicle
    public String exitVehicle(String licensePlate) {

        int index = hash(licensePlate);

        // Search using probing
        while (table[index].status != Status.EMPTY) {

            if (table[index].status == Status.OCCUPIED &&
                licensePlate.equals(table[index].licensePlate)) {

                long duration = System.currentTimeMillis() - table[index].entryTime;
                double hours = duration / (1000.0 * 60 * 60);

                double fee = hours * 10; // $10 per hour

                table[index].status = Status.DELETED;
                table[index].licensePlate = null;

                size--;

                return "Spot #" + index + " freed | Duration: " +
                        String.format("%.2f", hours) +
                        " hrs | Fee: $" + String.format("%.2f", fee);
            }

            index = (index + 1) % capacity;
        }

        return "Vehicle not found!";
    }

    // Get statistics
    public String getStatistics() {

        double occupancy = (size * 100.0) / capacity;
        double avgProbes = size == 0 ? 0 : (double) totalProbes / size;

        // Find peak hour
        int peakHour = 0;
        for (int i = 1; i < 24; i++) {
            if (hourlyUsage[i] > hourlyUsage[peakHour]) {
                peakHour = i;
            }
        }

        return "Occupancy: " + String.format("%.2f", occupancy) +
                "% | Avg Probes: " + String.format("%.2f", avgProbes) +
                " | Peak Hour: " + peakHour + ":00-" + (peakHour + 1) + ":00";
    }

    // Main method
    public static void main(String[] args) throws InterruptedException {

        SmartParkingOpenAddressing system =
                new SmartParkingOpenAddressing(10);

        System.out.println(system.parkVehicle("ABC-1234"));
        System.out.println(system.parkVehicle("ABC-1235"));
        System.out.println(system.parkVehicle("XYZ-9999"));

        Thread.sleep(2000);

        System.out.println(system.exitVehicle("ABC-1234"));

        System.out.println(system.getStatistics());
    }
}
