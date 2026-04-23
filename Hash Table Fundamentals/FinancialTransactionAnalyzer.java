import java.util.*;

// Transaction class
class Transaction {
    int amount;
    String merchant;
    String account;
    long timestamp;

    Transaction(int amount, String merchant, String account) {
        this.amount = amount;
        this.merchant = merchant;
        this.account = account;
        this.timestamp = System.currentTimeMillis();
    }
}

public class FinancialTransactionAnalyzer {

    // Store transactions
    private static List<Transaction> transactions = new ArrayList<>();

    // Add transaction
    public static void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // 1. Classic Two-Sum
    public static void twoSum(int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < transactions.size(); i++) {
            int amt = transactions.get(i).amount;
            int complement = target - amt;

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + amt);
            }
            map.put(amt, i);
        }
    }

    // 2. Two-Sum with 1-hour window
    public static void twoSumWithTime(int target) {
        HashMap<Integer, Transaction> map = new HashMap<>();

        long now = System.currentTimeMillis();

        for (Transaction t : transactions) {

            // Only consider last 1 hour
            if (now - t.timestamp <= 3600000) {
                int complement = target - t.amount;

                if (map.containsKey(complement)) {
                    System.out.println("Time-bound pair: " + complement + " + " + t.amount);
                }
                map.put(t.amount, t);
            }
        }
    }

    // 3. K-Sum (example for 3-sum)
    public static void threeSum(int target) {
        int n = transactions.size();

        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int complement = target - transactions.get(i).amount - transactions.get(j).amount;

                if (set.contains(complement)) {
                    System.out.println("Triplet found: "
                            + transactions.get(i).amount + ", "
                            + transactions.get(j).amount + ", "
                            + complement);
                }
                set.add(transactions.get(j).amount);
            }
        }
    }

    // 4. Duplicate detection
    public static void detectDuplicates() {
        HashSet<String> set = new HashSet<>();

        for (Transaction t : transactions) {
            String key = t.amount + "-" + t.merchant;

            if (set.contains(key)) {
                System.out.println("Duplicate detected: Amount "
                        + t.amount + " at " + t.merchant);
            } else {
                set.add(key);
            }
        }
    }

    public static void main(String[] args) {

        // Sample data
        addTransaction(new Transaction(100, "Amazon", "A1"));
        addTransaction(new Transaction(200, "Flipkart", "A2"));
        addTransaction(new Transaction(300, "Amazon", "A3"));
        addTransaction(new Transaction(150, "Amazon", "A4"));
        addTransaction(new Transaction(200, "Flipkart", "A5"));

        // Run checks
        twoSum(300);
        twoSumWithTime(300);
        threeSum(600);
        detectDuplicates();
    }
}
