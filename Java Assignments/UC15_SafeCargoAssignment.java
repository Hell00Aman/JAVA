// UC15: Safe Cargo Assignment using try-catch-finally

import java.util.*;

// Step 1: Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Step 2: Goods Bogie Class
class GoodsBogie {
    String shape;
    String cargo;

    GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Method to assign cargo safely
    public void assignCargo(String cargo) {
        try {
            // Validation rule
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Petroleum cannot be assigned to Rectangular bogie");
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo '" + cargo + "' assigned to " + shape + " bogie");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed for " + shape + " bogie\n");
        }
    }

    @Override
    public String toString() {
        return shape + " Bogie carrying: " + (cargo != null ? cargo : "No Cargo");
    }
}

// Step 3: Main Application
public class UC15_SafeCargoAssignment {
    public static void main(String[] args) {

        List<GoodsBogie> train = new ArrayList<>();

        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        GoodsBogie g2 = new GoodsBogie("Rectangular");

        train.add(g1);
        train.add(g2);

        // Safe Assignment
        g1.assignCargo("Petroleum");

        // Unsafe Assignment
        g2.assignCargo("Petroleum");

        // Another Safe Assignment
        g2.assignCargo("Coal");

        // Final Train Status
        System.out.println("Final Train Consist:");
        for (GoodsBogie g : train) {
            System.out.println(g);
        }
    }
}
