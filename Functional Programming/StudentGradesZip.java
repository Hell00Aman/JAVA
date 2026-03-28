// StudentGradesZip.java
// This program pairs students with their grades similar to Python's zip()
// and prints them neatly.

import java.util.*;

public class StudentGradesZip {

    public static void main(String[] args) {

        // List of student names
        List<String> students = Arrays.asList("Aman", "Rahul", "Priya", "Neha");

        // List of grades
        List<Integer> grades = Arrays.asList(85, 90, 78, 92);

        // Pair and print (zip-like behavior)
        for (int i = 0; i < students.size() && i < grades.size(); i++) {
            System.out.println(students.get(i) + " : " + grades.get(i));
        }
    }
}
