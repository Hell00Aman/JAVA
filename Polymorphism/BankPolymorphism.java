// Parent class Bank
class Bank {
    // Method to return rate of interest
    double rateOfInterest() {
        return 0;
    }
}

// Subclass SBI
class SBI extends Bank {
    // Overriding rateOfInterest method
    double rateOfInterest() {
        return 6.5;
    }
}

// Subclass HDFC
class HDFC extends Bank {
    // Overriding rateOfInterest method
    double rateOfInterest() {
        return 7.0;
    }
}

// Subclass ICICI
class ICICI extends Bank {
    // Overriding rateOfInterest method
    double rateOfInterest() {
        return 6.8;
    }
}

// Main class to demonstrate polymorphism
public class BankPolymorphism {
    public static void main(String[] args) {
        
        // Parent class reference and child class objects
        Bank b;
        
        // SBI object
        b = new SBI();
        System.out.println("SBI Interest Rate: " + b.rateOfInterest() + "%");
        
        // HDFC object
        b = new HDFC();
        System.out.println("HDFC Interest Rate: " + b.rateOfInterest() + "%");
        
        // ICICI object
        b = new ICICI();
        System.out.println("ICICI Interest Rate: " + b.rateOfInterest() + "%");
    }
}
