// Base class Animal
class Animal {
    String name;
    int age;

    // Method to set common animal details
    void setAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    void showAnimal() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Lion class derived from Animal
class Lion extends Animal {
    // Lion-specific method
    void roar() {
        showAnimal(); // calling base class method
        System.out.println("Lion roars loudly!");
    }
}

// Elephant class derived from Animal
class Elephant extends Animal {
    // Elephant-specific method
    void trumpet() {
        showAnimal();
        System.out.println("Elephant trumpets!");
    }
}

// Monkey class derived from Animal
class Monkey extends Animal {
    // Monkey-specific method
    void climb() {
        showAnimal();
        System.out.println("Monkey climbs trees!");
    }
}

// Main class
public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {

        // Creating objects of each subclass
        Lion lion = new Lion();
        lion.setAnimal("Leo", 5);
        lion.roar();

        System.out.println();

        Elephant elephant = new Elephant();
        elephant.setAnimal("Ella", 10);
        elephant.trumpet();

        System.out.println();

        Monkey monkey = new Monkey();
        monkey.setAnimal("Momo", 3);
        monkey.climb();
    }
}
