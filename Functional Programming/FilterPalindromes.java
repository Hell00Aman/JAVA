import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPalindromes {

    // Method to check if a word is palindrome
    public static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "madam", "apple", "level", "banana", "radar", "java"
        );

        // Filter palindrome words
        List<String> palindromes = words.stream()
                .filter(FilterPalindromes::isPalindrome)
                .collect(Collectors.toList());

        System.out.println("Palindrome words: " + palindromes);
    }
}
