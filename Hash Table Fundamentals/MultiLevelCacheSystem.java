import java.util.*;

// Generic LRU Cache using LinkedHashMap
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    // Remove least recently used entry
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

// Main Cache System
public class MultiLevelCacheSystem {

    // L1, L2 caches
    private LRUCache<String, String> L1 = new LRUCache<>(10000);
    private LRUCache<String, String> L2 = new LRUCache<>(100000);

    // L3 (Database simulation)
    private HashMap<String, String> L3 = new HashMap<>();

    // Metrics
    private int L1Hits = 0, L2Hits = 0, L3Hits = 0;

    // Get video
    public String get(String key) {

        // Check L1
        if (L1.containsKey(key)) {
            L1Hits++;
            return L1.get(key);
        }

        // Check L2
        if (L2.containsKey(key)) {
            L2Hits++;
            String value = L2.get(key);

            // Promote to L1
            L1.put(key, value);
            return value;
        }

        // Check L3 (DB)
        if (L3.containsKey(key)) {
            L3Hits++;
            String value = L3.get(key);

            // Promote to L2 and L1
            L2.put(key, value);
            L1.put(key, value);
            return value;
        }

        return null; // Not found
    }

    // Put video into database (L3)
    public void put(String key, String value) {
        L3.put(key, value);
    }

    // Invalidate cache (content update)
    public void invalidate(String key) {
        L1.remove(key);
        L2.remove(key);
        L3.remove(key);
    }

    // Print hit ratios
    public void printStats() {
        int total = L1Hits + L2Hits + L3Hits;

        System.out.println("L1 Hits: " + L1Hits);
        System.out.println("L2 Hits: " + L2Hits);
        System.out.println("L3 Hits: " + L3Hits);

        if (total > 0) {
            System.out.println("L1 Hit Ratio: " + (double) L1Hits / total);
            System.out.println("L2 Hit Ratio: " + (double) L2Hits / total);
            System.out.println("L3 Hit Ratio: " + (double) L3Hits / total);
        }
    }

    public static void main(String[] args) {

        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();

        // Load data into L3 (DB)
        cache.put("video1", "Movie A");
        cache.put("video2", "Movie B");
        cache.put("video3", "Movie C");

        // Access videos
        System.out.println(cache.get("video1")); // L3 → L2 → L1
        System.out.println(cache.get("video1")); // L1 hit
        System.out.println(cache.get("video2")); // L3 → promote

        // Invalidate example
        cache.invalidate("video1");

        // Stats
        cache.printStats();
    }
}
