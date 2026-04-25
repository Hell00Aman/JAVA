import java.util.*;

// Transaction class
class Transaction {
    double fee;
    long timestamp;

    Transaction(double fee, long timestamp) {
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return "Fee: $" + fee + ", Time: " + timestamp;
    }
}

public class TransactionFeeSorter {

    // Bubble Sort (for ≤100 transactions)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent fees
                if (list.get(j).fee > list.get(j + 1).fee) {

                    // Swap
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }

            // Early termination if no swaps
            if (!swapped) break;
        }
    }

    // Insertion Sort (for 100–1000 transactions)
    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {

            Transaction key = list.get(i);
            int j = i - 1;

            // Sort by fee, then timestamp (stable)
            while (j >= 0 &&
                   (list.get(j).fee > key.fee ||
                   (list.get(j).fee == key.fee &&
                    list.get(j).timestamp > key.timestamp))) {

                list.set(j + 1, list.get(j)); // shift right
                j--;
            }

            list.set(j + 1, key);
        }
    }

    // Flag high-fee outliers
    public static void flagOutliers(List<Transaction> list) {
        System.out.println("\nHigh Fee Transactions (> $50):");
        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
            }
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        // Sample input
        transactions.add(new Transaction(30, 1001));
        transactions.add(new Transaction(60, 1002));
        transactions.add(new Transaction(20, 1003));
        transactions.add(new Transaction(60, 1000));
        transactions.add(new Transaction(10, 1004));

        int size = transactions.size();

        // Choose sorting method based on size
        if (size <= 100) {
            bubbleSort(transactions);
        } else {
            insertionSort(transactions);
        }

        // Display sorted transactions
        System.out.println("Sorted Transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        // Flag outliers
        flagOutliers(transactions);
    }
}
