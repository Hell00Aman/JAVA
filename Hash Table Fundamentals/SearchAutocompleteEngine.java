import java.util.*;

// Trie Node class
class TrieNode {
    Map<Character, TrieNode> children; // child nodes
    Map<String, Integer> freqMap;      // queries and their frequencies

    public TrieNode() {
        children = new HashMap<>();
        freqMap = new HashMap<>();
    }
}

// Main Autocomplete System
public class SearchAutocompleteEngine {

    private TrieNode root;

    // Global frequency map
    private HashMap<String, Integer> globalFreq;

    public SearchAutocompleteEngine() {
        root = new TrieNode();
        globalFreq = new HashMap<>();
    }

    // Insert or update query
    public void insert(String query) {

        // Update frequency
        globalFreq.put(query, globalFreq.getOrDefault(query, 0) + 1);

        TrieNode current = root;

        // Insert into Trie
        for (char ch : query.toCharArray()) {

            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);

            // Store query frequency at each prefix node
            current.freqMap.put(query, globalFreq.get(query));
        }
    }

    // Get Top 10 suggestions
    public List<String> getSuggestions(String prefix) {

        TrieNode current = root;

        // Traverse prefix
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            current = current.children.get(ch);
        }

        // Min-heap for top 10
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : current.freqMap.entrySet()) {
            pq.offer(entry);

            if (pq.size() > 10) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        Collections.reverse(result); // highest first
        return result;
    }

    // Basic typo correction
    public List<String> getSuggestionsWithTypo(String prefix) {

        List<String> result = getSuggestions(prefix);

        // If no result → try removing last character
        if (result.isEmpty() && prefix.length() > 1) {
            return getSuggestions(prefix.substring(0, prefix.length() - 1));
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {

        SearchAutocompleteEngine system = new SearchAutocompleteEngine();

        // Insert queries
        system.insert("google");
        system.insert("google");
        system.insert("go");
        system.insert("goal");
        system.insert("golf");
        system.insert("good");

        // Suggestions
        System.out.println(system.getSuggestions("go"));

        // Typo handling
        System.out.println(system.getSuggestionsWithTypo("gox"));
    }
}
