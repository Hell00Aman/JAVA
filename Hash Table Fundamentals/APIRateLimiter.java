import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Class representing token bucket for each client
class TokenBucket {
    private int capacity;          // Max tokens (limit)
    private double tokens;         // Current tokens
    private long lastRefillTime;   // Last refill timestamp
    private int refillRate;        // Tokens added per second

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRate = refillRate;
        this.lastRefillTime = System.currentTimeMillis();
    }

    // Refill tokens based on time elapsed
    private void refill() {
        long now = System.currentTimeMillis();
        double tokensToAdd = ((now - lastRefillTime) / 1000.0) * refillRate;

        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTime = now;
    }

    // Try to consume a token
    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }
}

// Main Rate Limiter System
public class DistributedRateLimiter {

    // clientId -> TokenBucket
    private ConcurrentHashMap<String, TokenBucket> clientBuckets;

    private static final int MAX_REQUESTS = 1000; // per hour
    private static final int REFILL_RATE = 1000 / 3600; // tokens per second

    public DistributedRateLimiter() {
        clientBuckets = new ConcurrentHashMap<>();
    }

    // Check if request is allowed
    public boolean isAllowed(String clientId) {

        clientBuckets.putIfAbsent(clientId,
                new TokenBucket(MAX_REQUESTS, REFILL_RATE));

        TokenBucket bucket = clientBuckets.get(clientId);

        return bucket.allowRequest();
    }

    // API response simulation
    public String handleRequest(String clientId) {
        if (isAllowed(clientId)) {
            return "Request Allowed";
        } else {
            return "Rate Limit Exceeded! Try again later.";
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        DistributedRateLimiter limiter = new DistributedRateLimiter();

        String client = "client_123";

        // Simulate requests
        for (int i = 0; i < 5; i++) {
            System.out.println(limiter.handleRequest(client));
        }
    }
}
