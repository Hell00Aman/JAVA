import java.util.*;

// DNS Cache System
public class DNSCacheSystem {

    // Inner class to store DNS entry details
    static class DNSEntry {
        String domain;
        String ipAddress;
        long expiryTime; // Expiry timestamp

        DNSEntry(String domain, String ipAddress, long ttl) {
            this.domain = domain;
            this.ipAddress = ipAddress;
            this.expiryTime = System.currentTimeMillis() + ttl * 1000; // TTL in ms
        }

        // Check if entry is expired
        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    // HashMap for domain -> DNSEntry
    private HashMap<String, DNSEntry> cache;

    // LinkedHashMap for LRU eviction (access-order)
    private LinkedHashMap<String, DNSEntry> lruCache;

    private int capacity;

    // Stats tracking
    private int hits = 0;
    private int misses = 0;

    // Constructor
    public DNSCacheSystem(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>();

        // LRU cache with access order
        lruCache = new LinkedHashMap<String, DNSEntry>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, DNSEntry> eldest) {
                return size() > DNSCacheSystem.this.capacity;
            }
        };
    }

    // Simulate upstream DNS lookup
    private String queryUpstream(String domain) {
        // Dummy IP generation (for demo)
        return "192.168.1." + new Random().nextInt(255);
    }

    // Resolve domain
    public synchronized String resolve(String domain, int ttl) {

        // Check if present in cache
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            // Check expiry
            if (!entry.isExpired()) {
                hits++;
                lruCache.get(domain); // Update LRU access
                return "Cache HIT → " + entry.ipAddress;
            } else {
                // Expired → remove
                cache.remove(domain);
                lruCache.remove(domain);
            }
        }

        // Cache MISS → query upstream
        misses++;
        String ip = queryUpstream(domain);

        DNSEntry newEntry = new DNSEntry(domain, ip, ttl);

        cache.put(domain, newEntry);
        lruCache.put(domain, newEntry);

        return "Cache MISS → " + ip;
    }

    // Get cache statistics
    public String getCacheStats() {
        int total = hits + misses;
        double hitRate = total == 0 ? 0 : (hits * 100.0) / total;

        return "Hit Rate: " + String.format("%.2f", hitRate) + "%";
    }

    // Background cleanup thread
    public void startCleanupThread() {
        Thread cleaner = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Run every 5 sec

                    Iterator<Map.Entry<String, DNSEntry>> it = cache.entrySet().iterator();

                    while (it.hasNext()) {
                        Map.Entry<String, DNSEntry> entry = it.next();
                        if (entry.getValue().isExpired()) {
                            lruCache.remove(entry.getKey());
                            it.remove();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        cleaner.setDaemon(true);
        cleaner.start();
    }

    // Main method for testing
    public static void main(String[] args) throws InterruptedException {

        DNSCacheSystem dns = new DNSCacheSystem(3);

        dns.startCleanupThread();

        System.out.println(dns.resolve("google.com", 3)); // MISS
        System.out.println(dns.resolve("google.com", 3)); // HIT

        Thread.sleep(4000); // wait for expiry

        System.out.println(dns.resolve("google.com", 3)); // EXPIRED → MISS

        System.out.println(dns.getCacheStats());
    }
}
