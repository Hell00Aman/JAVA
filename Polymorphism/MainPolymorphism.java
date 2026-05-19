// MainPolymorphism.java
// This file demonstrates Polymorphism in Java using a base class and subclasses.

// Base class representing a generic animal
class Animal {
    // A generic method that will be overridden by subclasses
    public void makeSound() {
        System.out.println("The animal makes a generic sound.");
    }
}

// Subclass representing a Dog, inheriting from Animal
class Dog extends Animal {
    // Overriding the base class method to provide specific dog behavior
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

// Subclass representing a Cat, inheriting from Animal
class Cat extends Animal {
    // Overriding the base class method to provide specific cat behavior
    @Override
    public void makeSound() {
        System.out.println("The cat meows: Meow! Meow!");
    }
}

// Main execution class
public class Main {
    public static void main(String[] args) {
        // Creating a generic Animal reference pointing to a Dog object
        // This is a classic example of runtime polymorphism
        Animal myDog = new Dog();
        
        // Creating a generic Animal reference pointing to a Cat object
        Animal myCat = new Cat();

        System.out.println("--- Polymorphism in Action ---");
        
        // Even though myDog and myCat are declared as type 'Animal',
        // Java looks at the actual object type at runtime and calls the specific method.
        myDog.makeSound(); // Outputs: The dog barks: Woof! Woof!
        myCat.makeSound(); // Outputs: The cat meows: Meow! Meow!
    }
}
