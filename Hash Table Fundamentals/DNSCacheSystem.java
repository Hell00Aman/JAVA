import java.util.*;

// Entry class to store IP and expiry time
class CacheEntry {
    String ip;
    long expiryTime;

    CacheEntry(String ip, long ttlSeconds) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }

    // Check if entry is expired
    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

// Main DNS Cache class
public class DNSCacheSystem {

    // LRU Cache using LinkedHashMap
    private final int capacity;
    private LinkedHashMap<String, CacheEntry> cache;

    // Metrics
    private int hits = 0;
    private int misses = 0;

    public DNSCacheSystem(int capacity) {
        this.capacity = capacity;

        // accessOrder=true → LRU behavior
        cache = new LinkedHashMap<String, CacheEntry>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, CacheEntry> eldest) {
                return size() > capacity; // LRU eviction
            }
        };
    }

    // Get IP from cache
    public String get(String domain) {

        if (cache.containsKey(domain)) {
            CacheEntry entry = cache.get(domain);

            // Check TTL expiration
            if (!entry.isExpired()) {
                hits++;
                return entry.ip;
            } else {
                cache.remove(domain); // Remove expired
            }
        }

        // Cache miss → fetch from upstream
        misses++;
        String ip = queryUpstreamDNS(domain);

        // Store in cache with TTL (e.g., 5 sec)
        put(domain, ip, 5);

        return ip;
    }

    // Put entry in cache
    public void put(String domain, String ip, int ttlSeconds) {
        cache.put(domain, new CacheEntry(ip, ttlSeconds));
    }

    // Simulated upstream DNS lookup
    private String queryUpstreamDNS(String domain) {
        System.out.println("Querying upstream DNS for: " + domain);

        // Dummy IP generation
        return "192.168.1." + new Random().nextInt(255);
    }

    // Display hit/miss ratio
    public void printStats() {
        int total = hits + misses;
        System.out.println("Cache Hits: " + hits);
        System.out.println("Cache Misses: " + misses);
        System.out.println("Hit Ratio: " + (total == 0 ? 0 : (double) hits / total));
    }

    public static void main(String[] args) {

        DNSCacheSystem dns = new DNSCacheSystem(3);

        // Test calls
        System.out.println(dns.get("google.com"));
        System.out.println(dns.get("openai.com"));
        System.out.println(dns.get("google.com")); // hit

        // Wait for TTL expiry
        try { Thread.sleep(6000); } catch (Exception e) {}

        System.out.println(dns.get("google.com")); // miss after expiry

        dns.printStats();
    }
}
