import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterWordsStartingWithA {
    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "Apple", "Banana", "Avocado", "Mango", "Apricot", "Grapes", "Almond"
        );

        // Using filter() to select words starting with 'A'
        List<String> result = words.stream()
                .filter(word -> word.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Words starting with A: " + result);
    }
}
