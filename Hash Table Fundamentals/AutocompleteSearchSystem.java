import java.util.*;

// Trie Node class
class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> frequencyMap; // store queries passing through this node

    public TrieNode() {
        children = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
}

// Main Autocomplete System
public class AutocompleteSearchSystem {

    private TrieNode root;

    // Global query frequency store
    private HashMap<String, Integer> globalFrequency;

    public AutocompleteSearchSystem() {
        root = new TrieNode();
        globalFrequency = new HashMap<>();
    }

    // Insert query into Trie
    public void insert(String query) {

        // Update global frequency
        globalFrequency.put(query, globalFrequency.getOrDefault(query, 0) + 1);

        TrieNode current = root;

        for (char ch : query.toCharArray()) {

            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);

            // Update frequency at each prefix node
            current.frequencyMap.put(query, globalFrequency.get(query));
        }
    }

    // Get top 10 suggestions for a prefix
    public List<String> getSuggestions(String prefix) {

        TrieNode current = root;

        // Traverse Trie for prefix
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return new ArrayList<>(); // no suggestions
            }
            current = current.children.get(ch);
        }

        // Use min-heap for top 10
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : current.frequencyMap.entrySet()) {
            pq.offer(entry);

            if (pq.size() > 10) {
                pq.poll(); // remove smallest
            }
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        Collections.reverse(result); // highest frequency first

        return result;
    }

    // Simple typo handling (basic approach)
    public List<String> getSuggestionsWithTypo(String prefix) {
        List<String> suggestions = getSuggestions(prefix);

        // If empty → try removing last character (basic correction)
        if (suggestions.isEmpty() && prefix.length() > 1) {
            return getSuggestions(prefix.substring(0, prefix.length() - 1));
        }

        return suggestions;
    }

    // Main method for testing
    public static void main(String[] args) {

        AutocompleteSearchSystem system = new AutocompleteSearchSystem();

        // Insert sample queries
        system.insert("apple");
        system.insert("app");
        system.insert("application");
        system.insert("app");
        system.insert("apply");
        system.insert("banana");

        // Get suggestions
        System.out.println(system.getSuggestions("app"));

        // Typo handling
        System.out.println(system.getSuggestionsWithTypo("applx"));
    }
}
