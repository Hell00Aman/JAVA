// Import required packages
import java.util.*;

// Main class
public class CombineLists {

    public static void main(String[] args) {

        // Create first list: Students
        List<String> students = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Create second list: Marks
        List<Integer> marks = Arrays.asList(85, 90, 78, 88);

        // Create a Map (Dictionary in Java)
        Map<String, Integer> studentMarks = new HashMap<>();

        // Combine both lists using loop (similar to zip)
        for (int i = 0; i < students.size(); i++) {
            studentMarks.put(students.get(i), marks.get(i));
        }

        // Display the dictionary
        System.out.println("Student Marks Dictionary:");
        System.out.println(studentMarks);
    }
}
