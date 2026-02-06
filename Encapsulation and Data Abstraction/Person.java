// Demonstrates encapsulation using private variables with getters and setters

class Person {

    // Private instance variables
    private String name;
    private int age;
    private String country;

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter for age
    public int getAge() {
        return age;
    }

    // Public setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Public getter for country
    public String getCountry() {
        return country;
    }

    // Public setter for country
    public void setCountry(String country) {
        this.country = country;
    }
}

// Main class to test Person
public class Main {
    public static void main(String[] args) {

        // Creating object of Person class
        Person p = new Person();

        // Setting values using setter methods
        p.setName("David");
        p.setAge(25);
        p.setCountry("India");

        // Accessing values using getter methods
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Country: " + p.getCountry());
    }
}
