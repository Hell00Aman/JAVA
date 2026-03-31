// File: ReverseStringRecursive.java

public class ReverseStringRecursive {

    // Recursive function to reverse a string
    public static String reverse(String str) {

        // Base case: if string is empty or has one character
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case:
        // Take substring from index 1 and reverse it,
        // then add first character at the end
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String input = "Hello";

        // Calling recursive function
        String reversed = reverse(input);

        // Output result
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
