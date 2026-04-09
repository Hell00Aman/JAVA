// File: NFAEndsWith010.java

import java.util.*;

public class NFAEndsWith010 {

    // Function to simulate NFA
    public static boolean accepts(String input) {

        // Current states (NFA can have multiple states at once)
        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(0); // Start state

        for (char ch : input.toCharArray()) {

            Set<Integer> nextStates = new HashSet<>();

            for (int state : currentStates) {

                switch (state) {

                    case 0:
                        if (ch == '0') {
                            nextStates.add(0);
                            nextStates.add(1); // NFA branch
                        } else if (ch == '1') {
                            nextStates.add(0);
                        }
                        break;

                    case 1:
                        if (ch == '1') {
                            nextStates.add(2);
                        }
                        break;

                    case 2:
                        if (ch == '0') {
                            nextStates.add(3);
                        }
                        break;

                    case 3:
                        // Final state (no outgoing transitions needed)
                        break;
                }
            }

            currentStates = nextStates;
        }

        // Accept if final state (3) is reached
        return currentStates.contains(3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String input = sc.nextLine();

        if (accepts(input)) {
            System.out.println("Accepted (Ends with 010)");
        } else {
            System.out.println("Rejected");
        }

        sc.close();
    }
}
