// Parking Lot System using Linear Probing (Open Addressing)

public class ParkingLot {

    // Class representing each parking spot
    static class ParkingSpot {
        String licensePlate;   // stores car number
        boolean isOccupied;    // checks if spot is occupied

        ParkingSpot() {
            this.isOccupied = false; // initially empty
        }
    }

    private ParkingSpot[] spots; // hash table (array)
    private int capacity;        // total parking spots

    // Constructor to initialize parking lot
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spots = new ParkingSpot[capacity];

        // Initialize each spot
        for (int i = 0; i < capacity; i++) {
            spots[i] = new ParkingSpot();
        }
    }

    // Hash function (converts license plate → index)
    private int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % capacity;
    }

    // ================= PARK CAR =================
    // Uses linear probing to resolve collisions
    public boolean parkCar(String licensePlate) {

        int index = hash(licensePlate);     // initial index
        int originalIndex = index;          // to detect full loop
        int probes = 0;                     // count probes (performance)

        // If spot occupied → move to next slot
        while (spots[index].isOccupied) {

            probes++;
            index = (index + 1) % capacity; // linear probing

            // If we return to original index → table full
            if (index == originalIndex) {
                System.out.println("Parking lot FULL!");
                return false;
            }
        }

        // Insert car into found empty spot
        spots[index].licensePlate = licensePlate;
        spots[index].isOccupied = true;

        System.out.println("Parked " + licensePlate +
                " at spot " + index +
                " (probes: " + probes + ")");

        return true;
    }

    // ================= FIND CAR =================
    // Searches using same probing sequence
    public boolean findCar(String licensePlate) {

        int index = hash(licensePlate);
        int originalIndex = index;

        // Traverse until empty slot or full loop
        while (spots[index].isOccupied) {

            if (spots[index].licensePlate.equals(licensePlate)) {
                System.out.println("Found " + licensePlate +
                        " at spot " + index);
                return true;
            }

            index = (index + 1) % capacity;

            if (index == originalIndex) break;
        }

        System.out.println(licensePlate + " not found");
        return false;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(5);

        // Insert cars
        lot.parkCar("ABC123");
        lot.parkCar("XYZ789");
        lot.parkCar("DEF456"); // may cause collision

        // Search cars
        lot.findCar("XYZ789");
        lot.findCar("NOTHERE");
    }
}
