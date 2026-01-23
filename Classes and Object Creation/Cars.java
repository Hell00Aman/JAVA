// Package: transport
package transport;

// Subclass in same package
public class Car extends Vehicle {

    public void showSpeed() {
        // Accessing protected variable
        speed = 80;
        System.out.println("Car speed: " + speed);
    }
}
