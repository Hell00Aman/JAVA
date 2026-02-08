// Demonstrates single inheritance in Java

// Base class Teacher
class Teacher {

    // Data members of base class
    protected String name;
    protected String subject;

    // Constructor of Teacher class
    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    // Method to display teacher details
    void displayTeacher() {
        System.out.println("Teacher Name: " + name);
        System.out.println("Subject: " + subject);
    }
}

// Derived class MathTeacher inherits Teacher
class MathTeacher extends Teacher {

    // Additional data member of derived class
    private int numberOfClasses;

    // Constructor of MathTeacher class
    MathTeacher(String name, int numberOfClasses) {
        // Calling base class constructor
        super(name, "Mathematics");
        this.numberOfClasses = numberOfClasses;
    }

    // Method to display MathTeacher details
    void displayMathTeacher() {
        displayTeacher(); // accessing base class method
        System.out.println("Classes Handled: " + numberOfClasses);
    }
}

// Main class
public class SingleInheritanceTeacher {
    public static void main(String[] args) {

        // Creating object of derived class
        MathTeacher mt = new MathTeacher("Mr. Kumar", 5);

        // Displaying details
        mt.displayMathTeacher();
    }
}
