// Parent class
class Bank {
    // Method to return rate of interest
    double rateOfInterest() {
        return 0; // default value
    }
}

// Subclass SBI
class SBI extends Bank {
    // Override rateOfInterest method
    double rateOfInterest() {
        return 6.5;
    }
}

// Subclass HDFC
class HDFC extends Bank {
    // Override rateOfInterest method
    double rateOfInterest() {
        return 7.2;
    }
}

// Subclass ICICI
class ICICI extends Bank {
    // Override rateOfInterest method
    double rateOfInterest() {
        return 6.8;
    }
}

// Main class
public class BankTest {
    public static void main(String[] args) {
        
        // Create objects of subclasses
        SBI s = new SBI();
        HDFC h = new HDFC();
        ICICI i = new ICICI();
        
        // Display interest rates
        System.out.println("SBI Interest Rate: " + s.rateOfInterest() + "%");
        System.out.println("HDFC Interest Rate: " + h.rateOfInterest() + "%");
        System.out.println("ICICI Interest Rate: " + i.rateOfInterest() + "%");
    }
}
