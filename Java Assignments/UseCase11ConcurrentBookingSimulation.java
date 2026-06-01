import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * File: UseCase11ConcurrentBookingSimulation.java
 * Description: Simulates a multi-threaded hotel booking system. 
 * Uses synchronization to protect shared mutable state (inventory and queue),
 * preventing race conditions and double-booking during concurrent requests.
 */
public class UseCase11ConcurrentBookingSimulation {

    // Shared Mutable State
    private static int availableRooms = 5; 
    private static final Queue<String> bookingQueue = new LinkedList<>();
    private static final AtomicInteger successfulBookings = new AtomicInteger(0);

    // Lock object for synchronization
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("=== Starting Concurrent Booking Simulation ===");
        System.out.println("Initial Available Rooms: " + availableRooms + "\n");

        // Simulating 10 concurrent guest requests
        int totalRequests = 10;
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 1. Simulating guests adding requests to the shared queue concurrently
        for (int i = 1; i <= totalRequests; i++) {
            String guestName = "Guest-" + i;
            executor.execute(() -> {
                synchronized (lock) {
                    bookingQueue.add(guestName);
                    System.out.println("[Queue] " + guestName + " added to the booking queue.");
                }
                
                // Process the booking immediately from the queue
                processNextBooking();
            });
        }

        // Shutdown executor and wait for all threads to finish
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        // 4. Display Final System State
        System.out.println("\n=== Simulation Completed ===");
        System.out.println("Total Successful Bookings: " + successfulBookings.get());
        System.out.println("Remaining Available Rooms: " + availableRooms);
        System.out.println("Queue Empty: " + bookingQueue.isEmpty());
    }

    /**
     * Critical Section: Retrieves and processes the booking request.
     * Synchronized access ensures only one thread updates inventory at a time.
     */
    private static void processNextBooking() {
        synchronized (lock) {
            // Check if there are requests in the queue
            if (!bookingQueue.isEmpty()) {
                String guest = bookingQueue.poll();
                
                System.out.println("[Processing] Checking availability for " + guest + "...");
                
                // Check inventory and allocate room safely
                if (availableRooms > 0) {
                    // Simulate slight processing delay to expose potential race conditions if unsynchronized
                    try { Thread.sleep(50); } catch (InterruptedException ignored) {}
                    
                    availableRooms--;
                    successfulBookings.incrementAndGet();
                    System.out.println("[SUCCESS] Room allocated to " + guest + ". Rooms left: " + availableRooms);
                } else {
                    System.out.println("[FAILED] No rooms available for " + guest);
                }
            }
        }
    }
}
