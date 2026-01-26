// Program to demonstrate different ways of creating strings and comparing them

public class StringManipulation {
    public static void main(String[] args) {

        // String created using string literal (stored in string pool)
        String s1 = "Java Programming";

        // String created using new keyword (stored in heap memory)
        String s2 = new String("Java Programming");

        // Character array
        char[] charArray = {'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};

        // String created from character array
        String s3 = new String(charArray);

        // Printing all strings
        System.out.println("String 1 (literal): " + s1);
        System.out.println("String 2 (new String()): " + s2);
        System.out.println("String 3 (char array): " + s3);

        // Comparing strings using ==
        System.out.println("Using == for comparison:");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));

        // Comparing strings using equals()
        System.out.println("\nUsing .equals() for comparison:");
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        // Explanation of comparison
        System.out.println("\nExplanation:");
        System.out.println("== checks memory reference, equals() checks content");

        // Escape sequence example
        System.out.println("\nString with Escape Sequences:");
        System.out.println("Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects");
    }
}
