import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ==========================================
// 1. SERVICE MODEL (Represents an Add-On)
// ==========================================
class Service {
    private final String serviceId;
    private final String serviceName;
    private final double price;

    public Service(String serviceId, String serviceName, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceId() { return serviceId; }
    public String getServiceName() { return serviceName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return serviceName + " ($" + price + ")";
    }
}

// ==========================================
// 2. MOCK RESERVATION (Core Booking Entity)
// ==========================================
class Reservation {
    private final String reservationId;
    private final String guestName;
    private final double baseRoomCost;

    public Reservation(String reservationId, String guestName, double baseRoomCost) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.baseRoomCost = baseRoomCost;
    }

    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public double getBaseRoomCost() { return baseRoomCost; }
}

// ==========================================
// 3. ADD-ON SERVICE MANAGER
// ==========================================
class AddOnServiceManager {
    // Key Concept: Map and List Combination for One-to-Many Relationship
    // Maps Reservation ID -> List of Selected Services
    private final Map<String, List<Service>> reservationServicesMap;

    public AddOnServiceManager() {
        this.reservationServicesMap = new HashMap<>();
    }

    /**
     * Associates an add-on service with a specific reservation.
     * Core inventory/booking state remains completely untouched here.
     */
    public void addServiceToReservation(String reservationId, Service service) {
        // If the reservation doesn't have any services yet, initialize an empty list
        reservationServicesMap.putIfAbsent(reservationId, new ArrayList<>());
        
        // Add the selected service to the list
        reservationServicesMap.get(reservationId).add(service);
        System.out.println("Successfully added [" + service.getServiceName() + "] to Reservation ID: " + reservationId);
    }

    /**
     * Retrieves all selected services for a given reservation.
     */
    public List<Service> getServicesForReservation(String reservationId) {
        return reservationServicesMap.getOrDefault(reservationId, new ArrayList<>());
    }

    /**
     * Cost Aggregation: Computes the total cost of all add-on services for a booking.
     */
    public double calculateTotalServiceCost(String reservationId) {
        List<Service> services = reservationServicesMap.get(reservationId);
        if (services == null || services.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (Service service : services) {
            total += service.getPrice();
        }
        return total;
    }
}

// ==========================================
// 4. MAIN EXECUTION CLASS
// ==========================================
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        System.out.println("=== Book My Stay: Use Case 7 - Add-On Service Selection ===");
        System.out.println("---------------------------------------------------------");

        // Step 1: Initialize the Add-On Service Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Step 2: Create Available Add-On Offerings
        Service wifi = new Service("SRV01", "Premium Wi-Fi", 15.0);
        Service breakfast = new Service("SRV02", "Buffet Breakfast", 25.0);
        Service spa = new Service("SRV03", "Luxury Spa Treatment", 120.0);
        Service airportShuttle = new Service("SRV04", "Airport Shuttle", 45.0);

        // Step 3: Simulate Existing Core Bookings (Simulated from previous use cases)
        Reservation reservation1 = new Reservation("RES-101", "Alice Smith", 250.0);
        Reservation reservation2 = new Reservation("RES-102", "Bob Jones", 400.0);

        System.out.println("Active Bookings Loaded:");
        System.out.println("- " + reservation1.getGuestName() + " (ID: " + reservation1.getReservationId() + ", Base: $" + reservation1.getBaseRoomCost() + ")");
        System.out.println("- " + reservation2.getGuestName() + " (ID: " + reservation2.getReservationId() + ", Base: $" + reservation2.getBaseRoomCost() + ")");
        System.out.println("---------------------------------------------------------\n");

        // Step 4: Guest Selection Process (Simulating UI interaction)
        System.out.println("--- Processing Add-On Selections ---");
        
        // Alice selects Breakfast and Spa
        serviceManager.addServiceToReservation(reservation1.getReservationId(), breakfast);
        serviceManager.addServiceToReservation(reservation1.getReservationId(), spa);
        
        // Bob selects Wi-Fi and Airport Shuttle
        serviceManager.addServiceToReservation(reservation2.getReservationId(), wifi);
        serviceManager.addServiceToReservation(reservation2.getReservationId(), airportShuttle);
        System.out.println("---------------------------------------------------------\n");

        // Step 5: Display Invoices & Cost Aggregation
        System.out.println("--- Booking Summaries (Post Add-On Selection) ---");
        
        displayBookingSummary(reservation1, serviceManager);
        displayBookingSummary(reservation2, serviceManager);
    }

    /**
     * Helper method to output aggregated billing insights cleanly.
     */
    private static void displayBookingSummary(Reservation reservation, AddOnServiceManager serviceManager) {
        String resId = reservation.getReservationId();
        List<Service> selectedServices = serviceManager.getServicesForReservation(resId);
        double addOnCost = serviceManager.calculateTotalServiceCost(resId);
        double totalInvoice = reservation.getBaseRoomCost() + addOnCost;

        System.out.println("Reservation Summary for: " + reservation.getGuestName() + " (" + resId + ")");
        System.out.println("  > Base Room Cost:       $" + reservation.getBaseRoomCost());
        System.out.println("  > Selected Add-Ons:     " + (selectedServices.isEmpty() ? "None" : selectedServices));
        System.out.println("  > Add-On Services Total: $" + addOnCost);
        System.out.println("  > Grand Total Invoice:  $" + totalInvoice);
        System.out.println("---------------------------------------------------------");
    }
}
