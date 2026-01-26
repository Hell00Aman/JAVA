// Program to demonstrate string methods using user input

import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Taking full name input
        System.out.print("Enter your full name (first and last name): ");
        String fullName = scanner.nextLine();

        // Taking favorite programming language input
        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        // Taking a sentence about programming experience
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        // Splitting full name into first and last name
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // Removing spaces from sentence
        String sentenceWithoutSpaces = sentence.replace(" ", "");

        // Counting characters excluding spaces
        int charCount = sentenceWithoutSpaces.length();

        // Converting language name to uppercase
        String languageUpperCase = language.toUpperCase();

        // Displaying output
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + languageUpperCase);
        System.out.println("Sentence Character Count (excluding spaces): " + charCount);

        // Closing scanner
        scanner.close();
    }
}
