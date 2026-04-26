import java.util.*;

// Client class
class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + " | Risk: " + riskScore + " | Balance: $" + accountBalance;
    }
}

public class ClientRiskRanking {

    // Bubble Sort (Ascending riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // Swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;

                    // Visualization of swap
                    System.out.println("Swapped: " + arr[j].name + " ↔ " + arr[j + 1].name);
                }
            }

            // Early stop
            if (!swapped) break;
        }
    }

    // Insertion Sort (Descending riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            // Sort by riskScore DESC, then accountBalance DESC
            while (j >= 0 &&
                  (arr[j].riskScore < key.riskScore ||
                  (arr[j].riskScore == key.riskScore &&
                   arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j]; // shift right
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Display Top 10 highest risk clients
    public static void top10(Client[] arr) {
        System.out.println("\nTop 10 High Risk Clients:");

        for (int i = 0; i < Math.min(10, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
            new Client("Aman", 40, 5000),
            new Client("Rahul", 70, 2000),
            new Client("Priya", 70, 8000),
            new Client("Neha", 20, 3000),
            new Client("Karan", 90, 1000),
            new Client("Simran", 60, 7000)
        };

        System.out.println("Bubble Sort (Ascending Risk):");
        bubbleSort(clients);

        System.out.println("\nAfter Bubble Sort:");
        for (Client c : clients) System.out.println(c);

        // Now sort for ranking
        insertionSort(clients);

        System.out.println("\nAfter Insertion Sort (Descending Risk):");
        for (Client c : clients) System.out.println(c);

        // Top 10
        top10(clients);
    }
}
