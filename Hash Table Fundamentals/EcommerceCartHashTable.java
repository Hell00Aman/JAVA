import java.util.*;

// Dynamic Hash Table implementation using Separate Chaining
public class DynamicHashTable {

    // Node (Entry) for storing key-value pairs
    static class Entry {
        String key;
        int value;
        Entry next; // Pointer for chaining (linked list)

        // Constructor to initialize entry
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] table;   // Array of buckets
    private int size;        // Number of key-value pairs
    private int capacity;    // Total number of buckets

    private final double LOAD_FACTOR = 0.75; // Threshold for resizing

    // Constructor to initialize hash table
    public DynamicHashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    // Hash function to compute index
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert key-value pair into hash table
    public void put(String key, int value) {

        // Check if resizing is needed
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }

        int index = hash(key);

        // Create new entry
        Entry newEntry = new Entry(key, value);

        // If bucket is empty, insert directly
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            // Collision handling using chaining
            newEntry.next = table[index];
            table[index] = newEntry;
        }

        size++; // Increase number of elements
    }

    // Resize the hash table when load factor exceeds threshold
    private void resize() {
        System.out.println("\n=== RESIZING ===");
        System.out.println("Old capacity: " + capacity + ", Size: " + size);
        System.out.println("Load factor: " + ((double) size / capacity));

        Entry[] oldTable = table;

        capacity *= 2; // Double the capacity
        table = new Entry[capacity];
        size = 0; // Reset size (will reinsert)

        System.out.println("New capacity: " + capacity);

        // Rehash all existing entries
        int rehashCount = 0;
        for (Entry entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value); // Reinsert
                rehashCount++;
                entry = entry.next;
            }
        }

        System.out.println("Rehashed " + rehashCount + " entries");
        System.out.println("=================\n");
    }

    // Display statistics of hash table
    public void displayStats() {
        System.out.println("Capacity: " + capacity);
        System.out.println("Size: " + size);
        System.out.println("Load Factor: " + ((double) size / capacity));

        // Show distribution of elements across buckets
        int[] chainLengths = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            Entry current = table[i];
            int length = 0;

            while (current != null) {
                length++;
                current = current.next;
            }

            if (length > 0) {
                chainLengths[i] = length;
            }
        }

        // Print non-empty buckets
        System.out.println("Non-empty buckets: ");
        for (int i = 0; i < capacity; i++) {
            if (chainLengths[i] > 0) {
                System.out.println(" Bucket " + i + ": " + chainLengths[i] + " entries");
            }
        }
    }

    // Main method (Real-time example: E-commerce shopping cart)
    public static void main(String[] args) {

        // Create hash table with initial capacity 4
        DynamicHashTable cart = new DynamicHashTable(4);

        System.out.println("Adding items to cart...\n");

        cart.put("laptop", 1);
        cart.displayStats();
        System.out.println();

        cart.put("mouse", 2);
        cart.displayStats();
        System.out.println();

        cart.put("keyboard", 1);
        cart.displayStats();
        System.out.println();

        // This insertion triggers resizing
        cart.put("monitor", 1);
        cart.displayStats();
        System.out.println();

        cart.put("webcam", 1);
        cart.displayStats();
    }
}
