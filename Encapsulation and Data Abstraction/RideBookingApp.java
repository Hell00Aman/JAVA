// Demonstrates abstraction in a ride-booking application

// Abstract class defining the ride booking process
abstract class RideService {

    // Abstract method: hides internal working from user
    public abstract void bookRide();
}

// Concrete class implementing hidden details
class CabRide extends RideService {

    // Implementation of abstract method
    public void bookRide() {
        // GPS tracking happens internally
        trackLocation();

        // Driver assignment happens internally
        assignDriver();

        // Payment processing happens internally
        processPayment();

        System.out.println("Ride booked successfully with one click!");
    }

    // Internal methods hidden from user
    private void trackLocation() {
        System.out.println("Tracking user location using GPS...");
    }

    private void assignDriver() {
        System.out.println("Assigning nearest available driver...");
    }

    private void processPayment() {
        System.out.println("Processing online payment...");
    }
}

// Main class
public class RideBookingApp {
    public static void main(String[] args) {

        // User interacts only with abstract service
        RideService ride = new CabRide();

        // One-click ride booking
        ride.bookRide();
    }
}
