import java.util.Arrays;   // Import Arrays class to create lists
import java.util.List;     // Import List interface
import java.util.ArrayList; // Import ArrayList to store result

public class ElementWiseSumUsingZip {

    public static void main(String[] args) {

        // Create first list of numbers
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);

        // Create second list of numbers
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);

        // Create a list to store the element-wise sum
        List<Integer> result = new ArrayList<>();

        // Loop through both lists similar to zip()
        for (int i = 0; i < list1.size(); i++) {

            // Add corresponding elements from both lists
            result.add(list1.get(i) + list2.get(i));
        }

        // Print the resulting list
        System.out.println("Element-wise sum: " + result);
    }
}
