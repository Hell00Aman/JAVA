import java.util.*;

// Class representing a transaction
class Transaction {
    String id;
    double amount;
    long timestamp; // in milliseconds
    String merchant;
    String account;

    public Transaction(String id, double amount, long timestamp, String merchant, String account) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.merchant = merchant;
        this.account = account;
    }
}

public class FinancialTransactionAnalyzer {

    // 1. Classic Two-Sum
    public static List<String> twoSum(List<Transaction> transactions, double target) {
        Map<Double, Transaction> map = new HashMap<>();

        for (Transaction t : transactions) {
            double complement = target - t.amount;

            if (map.containsKey(complement)) {
                return Arrays.asList(map.get(complement).id, t.id);
            }
            map.put(t.amount, t);
        }
        return new ArrayList<>();
    }

    // 2. Two-Sum with Time Window (1 hour)
    public static List<String> twoSumWithTimeWindow(List<Transaction> transactions, double target) {
        Map<Double, List<Transaction>> map = new HashMap<>();

        for (Transaction t : transactions) {
            double complement = target - t.amount;

            if (map.containsKey(complement)) {
                for (Transaction prev : map.get(complement)) {
                    if (Math.abs(t.timestamp - prev.timestamp) <= 3600000) { // 1 hour
                        return Arrays.asList(prev.id, t.id);
                    }
                }
            }

            map.putIfAbsent(t.amount, new ArrayList<>());
            map.get(t.amount).add(t);
        }
        return new ArrayList<>();
    }

    // 3. Duplicate Detection
    public static List<String> findDuplicates(List<Transaction> transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        for (Transaction t : transactions) {
            String key = t.amount + "-" + t.merchant;

            map.putIfAbsent(key, new ArrayList<>());
            for (Transaction prev : map.get(key)) {
                if (!prev.account.equals(t.account)) {
                    duplicates.add(prev.id + " & " + t.id);
                }
            }
            map.get(key).add(t);
        }
        return duplicates;
    }

    // 4. K-Sum (Recursive)
    public static boolean kSum(int[] nums, int k, int target, int start) {
        if (k == 2) {
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (set.contains(target - nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            if (kSum(nums, k - 1, target - nums[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("T1", 100, System.currentTimeMillis(), "Amazon", "A1"));
        transactions.add(new Transaction("T2", 200, System.currentTimeMillis(), "Flipkart", "A2"));
        transactions.add(new Transaction("T3", 300, System.currentTimeMillis(), "Amazon", "A3"));
        transactions.add(new Transaction("T4", 100, System.currentTimeMillis(), "Amazon", "A4"));

        // Classic Two-Sum
        System.out.println("Two-Sum: " + twoSum(transactions, 300));

        // Time Window Two-Sum
        System.out.println("Two-Sum (1hr): " + twoSumWithTimeWindow(transactions, 300));

        // Duplicate Detection
        System.out.println("Duplicates: " + findDuplicates(transactions));

        // K-Sum
        int[] nums = {100, 200, 300, 400};
        System.out.println("K-Sum (k=3, target=600): " + kSum(nums, 3, 600, 0));
    }
}
