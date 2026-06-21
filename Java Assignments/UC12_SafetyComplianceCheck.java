// UC12: Safety Compliance Check using Streams (allMatch + lambda)

import java.util.*;

// Goods Bogie class
class GoodsBogie {
    String shape;   // Cylindrical, Rectangular, Open, etc.
    String cargo;   // Petroleum, Coal, Grain, etc.

    GoodsBogie(String shape, String cargo) {
        this.shape = shape;
        this.cargo = cargo;
    }

    public String toString() {
        return shape + " -> " + cargo;
    }
}

public class UC12_SafetyComplianceCheck {

    public static void main(String[] args) {

        // Step 1: Create list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Open", "Grain"));
        // bogies.add(new GoodsBogie("Cylindrical", "Coal")); // ❌ Uncomment to test unsafe case

        // Step 2: Apply safety validation using allMatch()
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.shape.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
                );

        // Step 3: Display result
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }

        // Note:
        // Cylindrical bogie must carry only Petroleum
        // Non-cylindrical bogies can carry any cargo
        // allMatch() stops early if any violation is found
    }
}
