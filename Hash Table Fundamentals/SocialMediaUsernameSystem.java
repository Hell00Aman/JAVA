import java.util.*;

// Main class
public class UsernameAvailabilityChecker {

    // HashMap to store username -> userId (for availability check)
    private HashMap<String, Integer> userDatabase;

    // HashMap to store username -> attempt count (for popularity tracking)
    private HashMap<String, Integer> attemptFrequency;

    // Constructor
    public UsernameAvailabilityChecker() {
        userDatabase = new HashMap<>();
        attemptFrequency = new HashMap<>();
    }

    // Method to check username availability
    public boolean checkAvailability(String username) {

        // Increase attempt count
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);

        // Check if username exists (O(1) lookup)
        return !userDatabase.containsKey(username);
    }

    // Method to register a username
    public void registerUser(String username, int userId) {
        userDatabase.put(username, userId);
    }

    // Method to suggest alternative usernames
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        int i = 1;

        // Generate variations until we get 3 available suggestions
        while (suggestions.size() < 3) {
            String newName = username + i;

            if (!userDatabase.containsKey(newName)) {
                suggestions.add(newName);
            }
            i++;
        }

        // Add a modified version (replace underscore with dot)
        String modified = username.replace("_", ".");
        if (!userDatabase.containsKey(modified)) {
            suggestions.add(modified);
        }

        return suggestions;
    }

    // Method to get most attempted username
    public String getMostAttempted() {
        String maxUser = "";
        int maxCount = 0;

        // Traverse frequency map
        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxUser = entry.getKey();
            }
        }

        return maxUser + " (" + maxCount + " attempts)";
    }

    // Main method for testing
    public static void main(String[] args) {

        UsernameAvailabilityChecker system = new UsernameAvailabilityChecker();

        // Pre-existing users
        system.registerUser("john_doe", 101);
        system.registerUser("admin", 102);

        // Checking availability
        System.out.println(system.checkAvailability("john_doe"));   // false
        System.out.println(system.checkAvailability("jane_smith")); // true

        // Suggestions
        System.out.println(system.suggestAlternatives("john_doe"));

        // Simulate multiple attempts
        system.checkAvailability("admin");
        system.checkAvailability("admin");
        system.checkAvailability("admin");

        // Most attempted username
        System.out.println(system.getMostAttempted());
    }
}
