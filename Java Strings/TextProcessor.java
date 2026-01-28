// Program to clean, analyze, sort, and search text using Java string and collection methods

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TextProcessor {

    // Removes extra spaces from input text
    public static String cleanInput(String input) {
        String cleaned = input.replaceAll("\\s+", " ").trim();
        return cleaned;
    }

    // Analyzes text: counts words, characters, longest word, and most frequent character
    public static void analyzeText(String text) {

        // Splitting text into words
        String[] words = text.split(" ");
        int wordCount = words.length;

        // Counting characters excluding spaces
        int charCount = text.replace(" ", "").length();

        // Finding longest word
        String longestWord = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        // Counting frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerCaseChar = Character.toLowerCase(c);
                charFrequency.put(lowerCaseChar,
                        charFrequency.getOrDefault(lowerCaseChar, 0) + 1);
            }
        }

        // Finding most common character
        char mostCommonChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        // Displaying analysis results
        System.out.println("\n--- Text Analysis ---");
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count (excluding spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar +
                "' (appears " + maxCount + " times)");
    }

    // Returns words sorted alphabetically
    public static String[] getWordsSorted(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
        }
        Arrays.sort(words);
        return words;
    }

    // Main method
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.println("Enter a paragraph of text:");

        // Reading user input
        String userInput = scanner.nextLine();

        // Cleaning input
        String cleanedText = cleanInput(userInput);

        // Analyzing te
