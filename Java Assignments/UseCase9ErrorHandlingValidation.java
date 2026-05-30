// Custom exception for handling invalid booking scenarios
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Core system manager handling validation and inventory
class BookingManager {
    private int availableRooms = 2; // Mock inventory for testing

    public void processBooking(String roomType, int roomsRequested) throws InvalidBookingException {
        System.out.println("\n--- Processing Request: " + roomsRequested + " " + roomType + "(s) ---");
        
        // 1. Input Validation: Check room type
        if (!"Deluxe".equalsIgnoreCase(roomType) && !"Standard".equalsIgnoreCase(roomType)) {
            throw new InvalidBookingException("Error: Invalid room type '" + roomType + "'. We only offer Deluxe and Standard rooms.");
        }
        
        // 2. Input Validation: Check quantity bounds
        if (roomsRequested <= 0) {
            throw new InvalidBookingException("Error: Booking quantity must be greater than zero.");
        }
        
        // 3. Guarding System State: Fail-fast if inventory is insufficient
        if (roomsRequested > availableRooms) {
            throw new InvalidBookingException("Error: Insufficient inventory. Requested: " + roomsRequested + ", Available: " + availableRooms);
        }

        // Update state only after all validations pass successfully
        availableRooms -= roomsRequested;
        System.out.println("Success! Booking confirmed. Remaining inventory: " + availableRooms);
    }
}

// Main execution class
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();

        // Array of test cases representing various Guest inputs
        String[][] testBookings = {
            {"Deluxe", "1"},    // Valid case
            {"Suite", "1"},     // Invalid Room Type
            {"Standard", "-3"}, // Invalid Quantity
            {"Deluxe", "5"}     // Exceeds Inventory Capacity
        };

        for (String[] booking : testBookings) {
            try {
                String type = booking[0];
                int quantity = Integer.parseInt(booking[1]);
                
                // Try processing the booking
                manager.processBooking(type, quantity);
                
            } catch (InvalidBookingException e) {
                // Graceful failure handling: print message and keep application running safely
                System.out.println("[VALIDATION FAILED] " + e.getMessage());
            }
        }
        
        System.out.println("\n--- Execution Finished: System remained stable throughout errors. ---");
    }
}
