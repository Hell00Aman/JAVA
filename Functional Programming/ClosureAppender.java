import java.util.function.Function;

/**
 * Demonstrates a closure in Java that captures a base string.
 */
public class ClosureAppender {
    public static void main(String[] args) {
        // The variable 'base' is captured by the closure
        String base = "Hello, ";

        // The lambda expression acts as a closure
        // It captures 'base' and returns a function that appends a suffix
        Function<String, String> appender = (suffix) -> base + suffix;

        // Executing the returned function
        String result = appender.apply("World!");
        
        // Output: Hello, World!
        System.out.println(result);
    }
}
