import java.util.*;

// Class representing a page view event
class PageEvent {
    String url;
    String userId;
    String source;

    public PageEvent(String url, String userId, String source) {
        this.url = url;
        this.userId = userId;
        this.source = source;
    }
}

// Main Analytics System
public class RealTimeAnalyticsEngine {

    // pageUrl -> visit count
    private HashMap<String, Integer> pageViews;

    // pageUrl -> unique users
    private HashMap<String, HashSet<String>> uniqueVisitors;

    // source -> count
    private HashMap<String, Integer> trafficSources;

    public RealTimeAnalyticsEngine() {
        pageViews = new HashMap<>();
        uniqueVisitors = new HashMap<>();
        trafficSources = new HashMap<>();
    }

    // Process incoming event (O(1))
    public void processEvent(PageEvent event) {

        // Update page view count
        pageViews.put(event.url, pageViews.getOrDefault(event.url, 0) + 1);

        // Update unique visitors
        uniqueVisitors.putIfAbsent(event.url, new HashSet<>());
        uniqueVisitors.get(event.url).add(event.userId);

        // Update traffic source count
        trafficSources.put(event.source, trafficSources.getOrDefault(event.source, 0) + 1);
    }

    // Get Top 10 pages using PriorityQueue
    public List<String> getTopPages() {

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(pageViews.entrySet());

        List<String> result = new ArrayList<>();
        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            Map.Entry<String, Integer> entry = pq.poll();

            String url = entry.getKey();
            int views = entry.getValue();
            int unique = uniqueVisitors.get(url).size();

            result.add(url + " - " + views + " views (" + unique + " unique)");
            count++;
        }

        return result;
    }

    // Get traffic source distribution
    public Map<String, Double> getTrafficStats() {
        Map<String, Double> stats = new HashMap<>();

        int total = 0;
        for (int count : trafficSources.values()) {
            total += count;
        }

        for (Map.Entry<String, Integer> entry : trafficSources.entrySet()) {
            stats.put(entry.getKey(), (entry.getValue() * 100.0) / total);
        }

        return stats;
    }

    // Simulate dashboard update every 5 seconds
    public void startDashboard() {
        Thread dashboard = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);

                    System.out.println("\n===== DASHBOARD =====");

                    System.out.println("Top Pages:");
                    for (String page : getTopPages()) {
                        System.out.println(page);
                    }

                    System.out.println("\nTraffic Sources:");
                    for (Map.Entry<String, Double> entry : getTrafficStats().entrySet()) {
                        System.out.println(entry.getKey() + ": " +
                                String.format("%.2f", entry.getValue()) + "%");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        dashboard.setDaemon(true);
        dashboard.start();
    }

    // Main method for testing
    public static void main(String[] args) {

        RealTimeAnalyticsEngine system = new RealTimeAnalyticsEngine();

        system.startDashboard();

        // Simulating events
        system.processEvent(new PageEvent("/article/breaking-news", "user1", "google"));
        system.processEvent(new PageEvent("/article/breaking-news", "user2", "facebook"));
        system.processEvent(new PageEvent("/sports/championship", "user3", "direct"));
        system.processEvent(new PageEvent("/article/breaking-news", "user1", "google"));
    }
}
