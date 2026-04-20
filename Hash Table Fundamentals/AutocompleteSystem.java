import java.util.*;

// Main class
public class AutocompleteSystem {

    // HashMap to store query → frequency
    private static HashMap<String, Integer> queryFreq = new HashMap<>();

    // Add or update query frequency
    public static void addQuery(String query) {
        queryFreq.put(query, queryFreq.getOrDefault(query, 0) + 1);
    }

    // Get top 10 suggestions for a prefix
    public static List<String> getSuggestions(String prefix) {

        List<Map.Entry<String, Integer>> matched = new ArrayList<>();

        // Find matching queries (prefix search)
        for (String query : queryFreq.keySet()) {
            if (query.startsWith(prefix)) {
                matched.add(new AbstractMap.SimpleEntry<>(query, queryFreq.get(query)));
            }
        }

        // Sort by frequency (descending)
        matched.sort((a, b) -> b.getValue() - a.getValue());

        // Return top 10 results
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, matched.size()); i++) {
            result.add(matched.get(i).getKey());
        }

        return result;
    }

    // Simple typo correction (Levenshtein Distance)
    public static int editDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[a.length()][b.length()];
    }

    // Suggest closest match for typo
    public static String suggestCorrection(String input) {
        String bestMatch = null;
        int minDist = Integer.MAX_VALUE;

        for (String query : queryFreq.keySet()) {
            int dist = editDistance(input, query);
            if (dist < minDist) {
                minDist = dist;
                bestMatch = query;
            }
        }
        return bestMatch;
    }

    public static void main(String[] args) {

        // Sample queries (simulating history)
        addQuery("apple");
        addQuery("app");
        addQuery("application");
        addQuery("apply");
        addQuery("app"); // increase frequency
        addQuery("banana");
        addQuery("bat");
        addQuery("ball");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter search prefix: ");
        String prefix = sc.nextLine();

        List<String> suggestions = getSuggestions(prefix);

        if (suggestions.isEmpty()) {
            System.out.println("No exact matches. Did you mean: "
                    + suggestCorrection(prefix));
        } else {
            System.out.println("Top Suggestions:");
            for (String s : suggestions) {
                System.out.println(s);
            }
        }
    }
}
