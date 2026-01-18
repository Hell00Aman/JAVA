// Define the Student class
class Student {

    // Attributes of the student
    String name;
    int rollNumber;
    double marks;

    // Method to calculate grade based on marks
    String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}

// Main class to test the Student class
public class StudentTest {

    public static void main(String[] args) {

        // Create a Student object
        Student student = new Student();

        // Set student details
        student.name = "Rahul";
        student.rollNumber = 101;
        student.marks = 82.5;

        // Calculate grade
        String grade = student.calculateGrade();

        // Print student information along with grade
        System.out.println("Student Name: " + student.name);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Marks: " + student.marks);
        System.out.println("Grade: " + grade);
    }
}
`
