import java.util.*;

// Main class
public class PlagiarismDetector {

    // Hash table: n-gram → list of document IDs
    private static HashMap<String, List<Integer>> index = new HashMap<>();

    // Store documents
    private static HashMap<Integer, String> documents = new HashMap<>();

    // Add document and build index
    public static void addDocument(int docId, String text, int n) {
        documents.put(docId, text);

        List<String> ngrams = generateNGrams(text, n);

        for (String gram : ngrams) {
            index.putIfAbsent(gram, new ArrayList<>());
            index.get(gram).add(docId);
        }
    }

    // Generate n-grams
    public static List<String> generateNGrams(String text, int n) {
        List<String> result = new ArrayList<>();
        String[] words = text.split("\\s+");

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder gram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }
            result.add(gram.toString().trim());
        }
        return result;
    }

    // Check similarity
    public static void checkPlagiarism(String newDoc, int n) {

        List<String> newNGrams = generateNGrams(newDoc, n);
        HashMap<Integer, Integer> matchCount = new HashMap<>();

        // Count matching n-grams
        for (String gram : newNGrams) {
            if (index.containsKey(gram)) {
                for (int docId : index.get(gram)) {
                    matchCount.put(docId, matchCount.getOrDefault(docId, 0) + 1);
                }
            }
        }

        // Calculate similarity %
        for (int docId : matchCount.keySet()) {
            int matches = matchCount.get(docId);
            double similarity = (double) matches / newNGrams.size() * 100;

            System.out.println("Document " + docId + " similarity: " + similarity + "%");
        }

        // Find most similar document
        int bestDoc = -1, maxMatch = 0;
        for (int docId : matchCount.keySet()) {
            if (matchCount.get(docId) > maxMatch) {
                maxMatch = matchCount.get(docId);
                bestDoc = docId;
            }
        }

        if (bestDoc != -1) {
            System.out.println("Most similar document: " + bestDoc);
        } else {
            System.out.println("No plagiarism detected.");
        }
    }

    public static void main(String[] args) {

        int n = 3; // 3-grams

        // Add sample documents
        addDocument(1, "this is a sample document for plagiarism detection", n);
        addDocument(2, "this document is used for testing plagiarism system", n);

        // New document to check
        String newDoc = "this is a sample document for testing";

        checkPlagiarism(newDoc, n);
    }
}
