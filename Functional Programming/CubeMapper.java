import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeMapper {
    public static void main(String[] args) {
        // Create an immutable list of integers to process
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1. numbers.stream() - Converts the list into a Stream for functional processing
        // 2. .map(n -> n * n * n) - The lambda function: takes input 'n' and returns its cube
        // 3. .collect(...) - Gathers the results from the stream back into a usable List
        List<Integer> cubes = numbers.stream()
                                     .map(n -> n * n * n)
                                     .collect(Collectors.toList());

        // Print the original and the newly generated list to the console
        System.out.println("Original Numbers: " + numbers);
        System.out.println("Cubed Numbers:     " + cubes);
    }
}
