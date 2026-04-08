// File: DFAEndsWith11.java

import java.util.Scanner;

public class DFAEndsWith11 {

    // Function to simulate DFA
    public static boolean accepts(String input) {

        // States: q0 (start), q1, q2 (final)
        int state = 0;

        for (char ch : input.toCharArray()) {

            switch (state) {

                case 0: // q0
                    if (ch == '1') state = 1;
                    else state = 0;
                    break;

                case 1: // q1
                    if (ch == '1') state = 2;
                    else state = 0;
                    break;

                case 2: // q2 (accept state)
                    if (ch == '1') state = 2;
                    else state = 0;
                    break;
            }
        }

        // Accept if final state is q2
        return state == 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String input = sc.nextLine();

        if (accepts(input)) {
            System.out.println("Accepted (Ends with 11)");
        } else {
            System.out.println("Rejected (Does not end with 11)");
        }

        sc.close();
    }
}
