// Package: racing
package racing;

import transport.Vehicle;

// Subclass in different package
public class SportsCar extends Vehicle {

    public void displaySpeed() {
        // Protected variable accessible via inheritance
        speed = 120;
        System.out.println("SportsCar speed: " + speed);
    }
}
