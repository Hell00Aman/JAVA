// UC17: Sorting Bogie Names using Arrays.sort()

import java.util.Arrays;

public class UC17_SortBogieNames {

    public static void main(String[] args) {

        // Step 1: Input array of bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // Step 2: Use Arrays.sort()
        Arrays.sort(bogieNames);

        // Step 3: Display sorted array
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogieNames));
    }
}
