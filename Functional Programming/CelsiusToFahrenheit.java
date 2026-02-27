// This program converts a list of temperatures in Celsius
// to Fahrenheit using Stream map() method in Java.

import java.util.*;
import java.util.stream.*;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {

        // List of temperatures in Celsius
        List<Double> celsiusList = Arrays.asList(0.0, 25.0, 30.0, 37.0, 100.0);

        // Convert to Fahrenheit using map()
        List<Double> fahrenheitList = celsiusList.stream()
                .map(c -> (c * 9/5) + 32)
                .collect(Collectors.toList());

        // Display results
        System.out.println("Celsius: " + celsiusList);
        System.out.println("Fahrenheit: " + fahrenheitList);
    }
}
