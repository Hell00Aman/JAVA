// Define the Car class
class Car {

    // Attributes of the car
    String model;
    int year;
    String color;

    // Constructor to initialize car attributes
    Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Method to display car information
    void displayCarInfo() {
        System.out.println("Car Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("----------------------");
    }
}

// Main class to test the Car class
public class CarTest {

    public static void main(String[] args) {

        // Create first Car object
        Car car1 = new Car("Toyota Camry", 2022, "White");

        // Create second Car object
        Car car2 = new Car("Honda Civic", 2020, "Black");

        // Display information of both cars
        car1.displayCarInfo();
        car2.displayCarInfo();
    }
}
