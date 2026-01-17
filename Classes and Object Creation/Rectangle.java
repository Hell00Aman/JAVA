// Define the Rectangle class
class Rectangle {

    // Attributes of the rectangle
    double width;
    double height;

    // Method to calculate the area of the rectangle
    double calculateArea() {
        return width * height;
    }

    // Method to calculate the perimeter of the rectangle
    double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// Main class to test the Rectangle class
public class RectangleTest {

    public static void main(String[] args) {

        // Create a Rectangle object
        Rectangle rect = new Rectangle();

        // Set width and height
        rect.width = 10.5;
        rect.height = 5.0;

        // Calculate and print area
        System.out.println("Area of Rectangle: " + rect.calculateArea());

        // Calculate and print perimeter
        System.out.println("Perimeter of Rectangle: " + rect.calculatePerimeter());
    }
}
