// ReverseStringRecursion.java
// This program uses recursion to reverse a string

public class ReverseStringRecursion {

    public static void main(String[] args) {

        String input = "Hello";
        
        // Call recursive function
        String reversed = reverse(input);

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }

    // Recursive function to reverse string
    public static String reverse(String str) {

        // Base case: if string is empty or has one character
        if (str.isEmpty()) {
            return str;
        }

        // Recursive case: last character + reverse of remaining string
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
