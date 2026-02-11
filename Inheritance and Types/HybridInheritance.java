// Demonstrates Hybrid Inheritance in Java
// (Hierarchical + Interface-based Multiple Inheritance)

// Base class
class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void displayUser() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

// Subclass 1 (Hierarchical Inheritance)
class Customer extends User {
    public Customer(String name, String email) {
        super(name, email);
    }

    public void shop() {
        System.out.println(name + " is shopping.");
    }
}

// Subclass 2 (Hierarchical Inheritance)
class Seller extends User {
    public Seller(String name, String email) {
        super(name, email);
    }

    public void sell() {
        System.out.println(name + " is selling products.");
    }
}

// Interface (Multiple Inheritance via Interface)
interface PrimeFeatures {
    void fastDelivery();
    void exclusiveDeals();
}

// PrimeCustomer inherits Customer and implements PrimeFeatures
class PrimeCustomer extends Customer implements PrimeFeatures {

    public PrimeCustomer(String name, String email) {
        super(name, email);
    }

    @Override
    public void fastDelivery() {
        System.out.println("Fast delivery enabled.");
    }

    @Override
    public void exclusiveDeals() {
        System.out.println("Access to exclusive deals.");
    }
}

// Main class
public class HybridInheritanceDemo {
    public static void main(String[] args) {

        PrimeCustomer pc = new PrimeCustomer("Aman", "aman@email.com");

        pc.displayUser();
        pc.shop();
        pc.fastDelivery();
        pc.exclusiveDeals();
    }
}
