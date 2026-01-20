// Define the Person class
class Person {

    // Attributes of the person
    String name;
    int age;
    String address;

    // Default constructor
    Person() {
        name = "Unknown";
        age = 0;
        address = "Not Provided";
    }

    // Parameterized constructor
    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Method to display person information
    void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("-------------------------");
    }
}

// Main class to test the Person class
public class PersonTest {

    public static void main(String[] args) {

        // Create Person object using default constructor
        Person person1 = new Person();

        // Create Person object using parameterized constructor
        Person person2 = new Person("Amit", 25, "Mumbai");

        // Display information of both persons
        person1.displayPersonInfo();
        person2.displayPersonInfo();
    }
}
