// Import required packages
import java.util.*;

// Create a simple Pair class (tuple)
class Pair {
    int first;
    int second;

    // Constructor
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class SortTuplesBySecond {

    public static void main(String[] args) {

        // Create list of tuples (Pair objects)
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 5));
        list.add(new Pair(2, 3));
        list.add(new Pair(4, 1));
        list.add(new Pair(3, 4));

        // Sort using lambda based on second element
        list.sort((a, b) -> a.second - b.second);

        // Print sorted list
        for (Pair p : list) {
            System.out.println("(" + p.first + ", " + p.second + ")");
        }
    }
}
