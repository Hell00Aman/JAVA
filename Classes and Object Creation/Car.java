// Car class definition
public class Car {

    // Attributes of the Car class
    String model;
    int year;
    String color;

    // Constructor to initialize Car objects
    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Method to display car information
    public void displayCarInfo() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("--------------------");
    }

    // Main method to create objects and test the class
    public static void main(String[] args) {

        // Creating first Car object
        Car car1 = new Car("Toyota Corolla", 2020, "White");

        // Creating second Car object
        Car car2 = new Car("Honda Civic", 2022, "Black");

        // Displaying information of both cars
        car1.displayCarInfo();
        car2.displayCarInfo();
    }
}
