import java.util.*;
import java.util.concurrent.*;

// Token Bucket class for each client
class TokenBucket {
    int capacity;          // max tokens (limit)
    int tokens;            // current tokens
    long lastRefillTime;   // last refill timestamp

    public TokenBucket(int capacity) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    // Refill tokens based on time passed
    public void refill() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillTime;

        // Refill every hour (3600000 ms)
        if (elapsed >= 3600000) {
            tokens = capacity;
            lastRefillTime = now;
        }
    }

    // Try consuming a token
    public boolean allowRequest() {
        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }
}

// Main Rate Limiter
public class DistributedRateLimiter {

    // HashMap: clientID → TokenBucket
    private static ConcurrentHashMap<String, TokenBucket> clients = new ConcurrentHashMap<>();

    // Limit per client
    private static final int LIMIT = 1000;

    // Process API request
    public static void handleRequest(String clientId) {

        // Get or create token bucket (O(1))
        clients.putIfAbsent(clientId, new TokenBucket(LIMIT));
        TokenBucket bucket = clients.get(clientId);

        // Check rate limit
        if (bucket.allowRequest()) {
            System.out.println("Request allowed for " + clientId);
        } else {
            System.out.println("Rate limit exceeded for " + clientId +
                    " (Try again later)");
        }
    }

    public static void main(String[] args) {

        // Simulate multiple clients
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 1; i <= 2000; i++) {
            String clientId = "Client" + (i % 5); // 5 clients

            executor.execute(() -> handleRequest(clientId));
        }

        executor.shutdown();
    }
}
