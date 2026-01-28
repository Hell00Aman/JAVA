// Program to demonstrate string array operations in Java

public class StringArrays {

    // Method to find the longest name in the array
    public static String findLongestName(String[] names) {
        String longestName = "";
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        return longestName;
    }

    // Method to count names starting with a given letter
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        String lowerCaseLetter = String.valueOf(letter).toLowerCase();
        for (String name : names) {
            if (name.toLowerCase().startsWith(lowerCaseLetter)) {
                count++;
            }
        }
        return count;
    }

    // Method to format names as "Last, First"
    public static String[] formatNames(String[] names) {
        String[] formattedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            formattedNames[i] = parts[1] + ", " + parts[0];
        }
        return formattedNames;
    }

    // Main method
    public static void main(String[] args) {

        // Array of student names
        String[] students = {
            "John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"
        };

        // Displaying longest name
        System.out.println("Longest name: " + findLongestName(students));

        // Counting names starting with specific letters
        System.out.println("Number of names starting with 'J': " +
                countNamesStartingWith(students, 'J'));
        System.out.println("Number of names starting with 'D': " +
                countNamesStartingWith(students, 'D'));

        // Formatting names
        String[] formatted = formatNames(students);
        System.out.println("Formatted names:");

        // Printing formatted names
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
