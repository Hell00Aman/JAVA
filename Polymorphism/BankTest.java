// Parent class
class Bank {
    // Method to return rate of interest
    float rateOfInterest() {
        return 0;
    }
}

// SBI subclass inheriting Bank class
class SBI extends Bank {
    // Overriding rateOfInterest method
    float rateOfInterest() {
        return 8.4f;
    }
}

// ICICI subclass inheriting Bank class
class ICICI extends Bank {
    // Overriding rateOfInterest method
    float rateOfInterest() {
        return 7.3f;
    }
}

// HDFC subclass inheriting Bank class
class HDFC extends Bank {
    // Overriding rateOfInterest method
    float rateOfInterest() {
        return 8.1f;
    }
}

// Main class to test polymorphism
public class BankTest {
    public static void main(String[] args) {
        Bank b;

        b = new SBI();
        System.out.println("SBI Rate of Interest: " + b.rateOfInterest() + "%");

        b = new ICICI();
        System.out.println("ICICI Rate of Interest: " + b.rateOfInterest() + "%");

        b = new HDFC();
        System.out.println("HDFC Rate of Interest: " + b.rateOfInterest() + "%");
    }
}
