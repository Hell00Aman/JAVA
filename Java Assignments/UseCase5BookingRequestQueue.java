import java.util.*;

/**
 * Book My Stay - Hotel Booking Management System
 * Use Case 5: Booking Request Queue (FIFO)
 * 
 * Demonstrates Queue data structure for fair request handling.
 * Focus: FIFO, fairness, request ordering, no inventory mutation
 * 
 * @author Aman
 * @version 5.0
 */

// Reservation class (represents booking request)
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType);
    }
}

// Booking Queue Manager (FIFO)
class BookingQueue {

    // Queue to store booking requests
    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for " + reservation.guestName);
    }

    // View all requests (without removing)
    public void viewRequests() {
        System.out.println("\n--- Booking Requests in Queue (FIFO Order) ---");
        for (Reservation r : queue) {
            r.display();
        }
    }

    // Process next request (dequeue simulation)
    public Reservation processNext() {
        return queue.poll(); // removes first element (FIFO)
    }
}

// Main class
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v5.0 =====");

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Simulate incoming booking requests
        bookingQueue.addRequest(new Reservation("Aman", "Single Room"));
        bookingQueue.addRequest(new Reservation("Riya", "Suite Room"));
        bookingQueue.addRequest(new Reservation("John", "Double Room"));

        // Display queued requests
        bookingQueue.viewRequests();

        // Show FIFO processing (no inventory update here)
        System.out.println("\nProcessing next request...");
        Reservation next = bookingQueue.processNext();

        if (next != null) {
            System.out.println("Processing booking for:");
            next.display();
        }

        // Remaining queue
        bookingQueue.viewRequests();

        System.out.println("\n(No inventory was modified in this stage)");
        System.out.println("\nApplication Ended.");
    }
}
