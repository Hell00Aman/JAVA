import java.util.*;
import java.util.concurrent.*;

// Event class to represent a page view
class PageView {
    String page;
    String userId;
    String source;

    PageView(String page, String userId, String source) {
        this.page = page;
        this.userId = userId;
        this.source = source;
    }
}

// Main analytics system
public class RealTimeAnalyticsDashboard {

    // Frequency of page visits
    private static HashMap<String, Integer> pageCount = new HashMap<>();

    // Unique visitors per page
    private static HashMap<String, HashSet<String>> uniqueVisitors = new HashMap<>();

    // Traffic source counts
    private static HashMap<String, Integer> sourceCount = new HashMap<>();

    // Process incoming event (O(1))
    public static void processEvent(PageView event) {

        // Update page count
        pageCount.put(event.page, pageCount.getOrDefault(event.page, 0) + 1);

        // Track unique visitors
        uniqueVisitors.putIfAbsent(event.page, new HashSet<>());
        uniqueVisitors.get(event.page).add(event.userId);

        // Update traffic source count
        sourceCount.put(event.source, sourceCount.getOrDefault(event.source, 0) + 1);
    }

    // Get top 10 pages
    public static List<Map.Entry<String, Integer>> getTopPages() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(pageCount.entrySet());

        // Sort descending
        list.sort((a, b) -> b.getValue() - a.getValue());

        return list.subList(0, Math.min(10, list.size()));
    }

    // Display dashboard
    public static void displayDashboard() {

        System.out.println("\n===== DASHBOARD UPDATE =====");

        // Top pages
        System.out.println("Top Pages:");
        for (Map.Entry<String, Integer> entry : getTopPages()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " views");
        }

        // Traffic sources
        System.out.println("\nTraffic Sources:");
        for (String src : sourceCount.keySet()) {
            System.out.println(src + " -> " + sourceCount.get(src));
        }

        // Unique visitors example
        System.out.println("\nUnique Visitors per Page:");
        for (String page : uniqueVisitors.keySet()) {
            System.out.println(page + " -> " + uniqueVisitors.get(page).size());
        }
    }

    public static void main(String[] args) {

        // Scheduled dashboard updates every 5 seconds
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> displayDashboard(), 0, 5, TimeUnit.SECONDS);

        // Simulate streaming events
        String[] pages = {"Home", "News", "Sports", "Tech"};
        String[] sources = {"Google", "Facebook", "Direct"};

        Random rand = new Random();

        // Simulate continuous traffic
        for (int i = 1; i <= 100; i++) {

            PageView event = new PageView(
                    pages[rand.nextInt(pages.length)],
                    "User" + rand.nextInt(50),
                    sources[rand.nextInt(sources.length)]
            );

            processEvent(event);

            // Small delay to simulate real-time flow
            try { Thread.sleep(100); } catch (Exception e) {}
        }

        scheduler.shutdown();
    }
}
