import java.util.Arrays;      // Import Arrays class to create lists
import java.util.List;        // Import List interface
import java.util.HashMap;     // Import HashMap class
import java.util.Map;         // Import Map interface

public class MergeCountriesCapitals {

    public static void main(String[] args) {

        // Create a list of countries
        List<String> countries = Arrays.asList("India", "USA", "Japan", "France");

        // Create a list of capitals
        List<String> capitals = Arrays.asList("New Delhi", "Washington D.C.", "Tokyo", "Paris");

        // Create a map to store country-capital pairs (like a dictionary)
        Map<String, String> countryCapitalMap = new HashMap<>();

        // Loop through both lists and combine them similar to zip()
        for (int i = 0; i < countries.size(); i++) {
            countryCapitalMap.put(countries.get(i), capitals.get(i));
        }

        // Print the merged dictionary
        System.out.println("Country-Capital Dictionary: " + countryCapitalMap);
    }
}
