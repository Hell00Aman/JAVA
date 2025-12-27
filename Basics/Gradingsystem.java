import java.util.Scanner; // Import Scanner class for user input

public class cmnt {
    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter exam score
        System.out.print("Enter exam score: ");
        int score = sc.nextInt(); // Read score

        // Check for invalid score
        if (score < 0 || score > 100) {
            System.out.println("Invalid score input");
        } else {

            // Switch statement to assign grades
            switch (score / 10) {
                case 10: // Score between 100
                case 9:  // Score between 90–99
                    System.out.println("Grade: A (Excellent)");
                    break;

                case 8: // Score between 80–89
                    System.out.println("Grade: B (Very Good)");
                    break;

                case 7: // Score between 70–79
                    System.out.println("Grade: C (Good)");
                    break;

                case 6: // Score between 60–69
                    System.out.println("Grade: D (Satisfactory)");
                    break;

                default: // Score below 60
                    System.out.println("Grade: F (Fail)");
            }
        }

        // Close the scanner object
        sc.close();
    }
}
