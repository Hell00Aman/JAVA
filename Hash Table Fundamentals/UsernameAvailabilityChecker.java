import java.util.*;

// Main class
public class UsernameAvailabilityChecker {

    // HashSet for storing existing usernames (O(1) lookup)
    private static HashSet<String> users = new HashSet<>();

    // HashMap to track frequency of attempted usernames
    private static HashMap<String, Integer> frequency = new HashMap<>();

    public static void main(String[] args) {

        // Preloaded usernames (simulating existing users)
        users.add("aman");
        users.add("raj");
        users.add("john123");
        users.add("alex");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username to check: ");
        String username = sc.nextLine();

        // Update frequency count
        frequency.put(username, frequency.getOrDefault(username, 0) + 1);

        // Check availability
        if (users.contains(username)) {
            System.out.println("Username already taken!");

            // Suggest similar usernames
            suggestUsernames(username);
        } else {
            System.out.println("Username is available!");
        }

        // Display frequency count
        System.out.println("This username was searched "
                + frequency.get(username) + " time(s).");
    }

    // Method to suggest usernames
    public static void suggestUsernames(String username) {

        System.out.println("Suggested available usernames:");

        // Generate suggestions by adding numbers
        for (int i = 1; i <= 5; i++) {
            String suggestion = username + i;

            // Check if suggestion is available
            if (!users.contains(suggestion)) {
                System.out.println(suggestion);
            }
        }

        // Alternative suggestion (random number)
        String randomSuggestion = username + new Random().nextInt(1000);
        if (!users.contains(randomSuggestion)) {
            System.out.println(randomSuggestion);
        }
    }
}
