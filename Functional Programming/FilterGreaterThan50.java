import java.util.*;
import java.util.stream.*;

public class FilterGreaterThan50 {

    public static void main(String[] args) {

        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(10, 55, 23, 78, 90, 45, 60);

        // Using stream filter with lambda to get numbers > 50
        List<Integer> result = numbers.stream()
                                      .filter(n -> n > 50) // lambda expression
                                      .collect(Collectors.toList());

        // Printing result
        System.out.println("Numbers greater than 50: " + result);
    }
}
