import java.util.*;

// Video Data Class
class Video {
    String videoId;
    String data;

    public Video(String videoId, String data) {
        this.videoId = videoId;
        this.data = data;
    }
}

// LRU Cache using LinkedHashMap
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // access-order
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class MultiLevelCacheSystem {

    // L1, L2 caches
    private LRUCache<String, Video> L1 = new LRUCache<>(10000);
    private LRUCache<String, Video> L2 = new LRUCache<>(100000);

    // Simulated DB (L3)
    private Map<String, Video> database = new HashMap<>();

    // Access count tracking
    private Map<String, Integer> accessCount = new HashMap<>();

    // Get video
    public Video getVideo(String videoId) {

        // L1 Check
        if (L1.containsKey(videoId)) {
            System.out.println("L1 HIT");
            return L1.get(videoId);
        }

        // L2 Check
        if (L2.containsKey(videoId)) {
            System.out.println("L2 HIT → Promote to L1");
            Video v = L2.get(videoId);
            L1.put(videoId, v);
            return v;
        }

        // L3 (Database)
        if (database.containsKey(videoId)) {
            System.out.println("L3 HIT → Add to L2");
            Video v = database.get(videoId);
            L2.put(videoId, v);
            return v;
        }

        return null;
    }

    // Update access count & promote
    public void updateAccess(String videoId) {
        int count = accessCount.getOrDefault(videoId, 0) + 1;
        accessCount.put(videoId, count);

        // Promote if frequently accessed
        if (count > 5 && L2.containsKey(videoId)) {
            L1.put(videoId, L2.get(videoId));
        }
    }

    // Add video to DB
    public void addToDatabase(Video v) {
        database.put(v.videoId, v);
    }

    // Cache statistics
    public void getStats() {
        System.out.println("L1 Size: " + L1.size());
        System.out.println("L2 Size: " + L2.size());
        System.out.println("DB Size: " + database.size());
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();

        cache.addToDatabase(new Video("v1", "Movie1"));
        cache.addToDatabase(new Video("v2", "Movie2"));

        cache.getVideo("v1"); // L3 → L2
        cache.getVideo("v1"); // L2 → L1
        cache.getVideo("v1"); // L1 HIT

        cache.getStats();
    }
}
