// Base class Employee
class Employee {
    String name;
    double salary;

    // Method to set employee details
    void setEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee details
    void showEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

// Manager class derived from Employee
class Manager extends Employee {
    String department;

    // Method to set manager details
    void setManager(String department) {
        this.department = department;
    }

    // Method to display manager details
    void showManager() {
        showEmployee(); // calling base class method
        System.out.println("Department: " + department);
    }
}

// SeniorManager class derived from Manager
class SeniorManager extends Manager {
    int experience;

    // Method to set senior manager details
    void setSeniorManager(int experience) {
        this.experience = experience;
    }

    // Method to display senior manager details
    void showSeniorManager() {
        showManager(); // calling parent class method
        System.out.println("Experience: " + experience + " years");
    }
}

// Main class
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        // Creating object of SeniorManager
        SeniorManager sm = new SeniorManager();

        // Setting details
        sm.setEmployee("Aman", 75000);
        sm.setManager("IT");
        sm.setSeniorManager(10);

        // Displaying details at all levels
        sm.showSeniorManager();
    }
}
