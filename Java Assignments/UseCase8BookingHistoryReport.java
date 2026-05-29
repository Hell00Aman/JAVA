import java.util.ArrayList;
import java.util.List;

// Class representing a Reservation entity containing essential booking details
class Reservation {
    private final String bookingId;
    private final String guestName;
    private final String roomType;
    private final double totalAmount;

    public Reservation(String bookingId, String guestName, String roomType, double totalAmount) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.totalAmount = totalAmount;
    }

    public String getBookingId() { return bookingId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return String.format("ID: %s | Guest: %s | Room: %s | Paid: $%.2f", 
                bookingId, guestName, roomType, totalAmount);
    }
}

// Repository handling historical tracking of confirmed reservations
class BookingHistory {
    // List preserves chronological insertion order and allows sequential tracking
    private final List<Reservation> historyLog = new ArrayList<>();

    // Appends a confirmed booking to the audit trail
    public void recordBooking(Reservation reservation) {
        if (reservation != null) {
            historyLog.add(reservation);
        }
    }

    // Returns a copy of the history to prevent direct modification of internal state
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(historyLog);
    }
}

// Service dedicated to generating operational reports and visibility metrics
class BookingReportService {
    private final BookingHistory bookingHistory;

    public BookingReportService(BookingHistory bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    // Displays chronological log of all past bookings
    public void displayAuditTrail() {
        System.out.println("\n--- ADMINISTRATIVE AUDIT TRAIL ---");
        List<Reservation> records = bookingHistory.getAllReservations();
        if (records.isEmpty()) {
            System.out.println("No booking history found.");
            return;
        }
        for (Reservation res : records) {
            System.out.println(res);
        }
    }

    // Aggregates operational data to produce performance metrics
    public void generateSummaryReport() {
        System.out.println("\n--- MANAGEMENT SUMMARY REPORT ---");
        List<Reservation> records = bookingHistory.getAllReservations();
        
        int totalBookings = records.size();
        double totalRevenue = 0.0;
        int deluxeCount = 0;
        int standardCount = 0;

        for (Reservation res : records) {
            totalRevenue += res.getTotalAmount();
            if (res.getRoomType().equalsIgnoreCase("Deluxe")) {
                deluxeCount++;
            } else {
                standardCount++;
            }
        }

        System.out.println("Total Confirmed Bookings: " + totalBookings);
        System.out.printf("Total Revenue Generated : $%.2f\n", totalRevenue);
        System.out.println("Room Distribution       : Deluxe (" + deluxeCount + "), Standard (" + standardCount + ")");
    }
}

// Main executable driver to demonstrate Use Case 8 workflow
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        // Initialize core components
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService(history);

        System.out.println("System initialized. Processing bookings...");

        // Simulating the sequential confirmation of hotel bookings
        Reservation res1 = new Reservation("B001", "Alice Smith", "Deluxe", 250.00);
        history.recordBooking(res1);

        Reservation res2 = new Reservation("B002", "Bob Jones", "Standard", 120.50);
        history.recordBooking(res2);

        Reservation res3 = new Reservation("B003", "Charlie Brown", "Deluxe", 300.00);
        history.recordBooking(res3);

        // Admin invokes reporting and visibility metrics
        reportService.displayAuditTrail();
        reportService.generateSummaryReport();
    }
}
