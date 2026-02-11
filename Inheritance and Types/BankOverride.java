// Demonstrates method overriding and use of super keyword in Java

// Base class
class Bank {
    double interestRate = 5.0;  // Parent interest rate

    void displayRate() {
        System.out.println("Bank Interest Rate: " + interestRate + "%");
    }
}

// Subclass
class SBI extends Bank {
    double interestRate = 6.5;  // Child interest rate

    // Overriding method
    @Override
    void displayRate() {
        // Display parent class interest rate using super
        System.out.println("Parent Bank Interest Rate: " + super.interestRate + "%");

        // Display child class interest rate
        System.out.println("SBI Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankOverrideDemo {
    public static void main(String[] args) {

        SBI obj = new SBI();
        obj.displayRate();  // Calls overridden method
    }
}
