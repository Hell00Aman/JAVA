// Demonstrates data privacy using encapsulation in a hospital management system

class Patient {
    // Private health record (cannot be accessed directly)
    private String healthRecord;

    // Constructor to initialize health record
    public Patient(String record) {
        this.healthRecord = record;
    }

    // Authorized method for doctors to view health record
    public String getHealthRecord() {
        return healthRecord;
    }

    // Authorized method to update health record
    public void setHealthRecord(String record) {
        this.healthRecord = record;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a patient object
        Patient p = new Patient("Blood Pressure Normal");

        // Accessing health record using authorized method
        System.out.println("Health Record: " + p.getHealthRecord());

        // Updating health record securely
        p.setHealthRecord("Blood Pressure High");
        System.out.println("Updated Record: " + p.getHealthRecord());
    }
}
