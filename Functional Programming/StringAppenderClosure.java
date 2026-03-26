// StringAppenderClosure.java
// This program demonstrates a closure-like behavior in Java
// where a string is captured and a function appends another string to it.

import java.util.function.Function;

public class StringAppenderClosure {

    public static void main(String[] args) {

        // Create a closure that captures the base string
        Function<String, String> appender = createAppender("Hello");

        // Use the returned function to append strings
        System.out.println(appender.apply(" World"));
        System.out.println(appender.apply(" Java"));
    }

    // This method returns a function that remembers the base string
    public static Function<String, String> createAppender(String base) {

        // Lambda captures 'base' and appends new string to it
        return (suffix) -> base + suffix;
    }
}
