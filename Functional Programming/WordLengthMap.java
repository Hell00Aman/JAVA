// Import required packages
import java.util.*;
import java.util.stream.Collectors;

public class WordLengthMap {

    public static void main(String[] args) {

        // Create a list of words
        List<String> words = Arrays.asList("Java", "Python", "Programming", "Code", "Map");

        // Use Stream map() to calculate the length of each word
        List<Integer> wordLengths = words.stream()
                                         .map(word -> word.length()) // Get length of each word
                                         .collect(Collectors.toList()); // Store results in list

        // Print original words
        System.out.println("List of Words:");
        System.out.println(words);

        // Print length of each word
        System.out.println("\nLength of each word:");
        System.out.println(wordLengths);
    }
}
