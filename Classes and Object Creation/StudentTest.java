// File: StudentTest.java

// Student class with private variable
class Student {
    // private data member (cannot be accessed directly)
    private int marks;

    // public setter method to assign marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // public getter method to return marks
    public int getMarks() {
        return marks;
    }
}

// Main class
public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();

        // Setting marks using setter method
        s.setMarks(85);

        // Getting marks using getter method
        System.out.println("Marks: " + s.getMarks());

        // Direct access is NOT allowed (will cause error)
        // s.marks = 90;  // ❌ Compilation error
    }
}
