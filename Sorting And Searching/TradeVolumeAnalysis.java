import java.util.*;

// Trade class
class Trade {
    int volume;
    String id;

    Trade(int volume, String id) {
        this.volume = volume;
        this.id = id;
    }

    public String toString() {
        return id + " | Volume: " + volume;
    }
}

public class TradeVolumeAnalysis {

    // ================= MERGE SORT (Ascending, Stable) =================
    public static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge step
    public static void merge(Trade[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        // Copy data
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge sorted arrays
        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) { // stable
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ================= QUICK SORT (Descending) =================
    public static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Lomuto partition (Descending)
    public static int partition(Trade[] arr, int low, int high) {

        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].volume > pivot) { // DESC
                i++;

                // swap
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot
        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ================= MERGE TWO SORTED LISTS =================
    public static Trade[] mergeLists(Trade[] a, Trade[] b) {

        Trade[] result = new Trade[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    // ================= TOTAL VOLUME =================
    public static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) sum += t.volume;
        return sum;
    }

    public static void main(String[] args) {

        Trade[] trades = {
            new Trade(500, "T1"),
            new Trade(200, "T2"),
            new Trade(800, "T3"),
            new Trade(300, "T4")
        };

        // Merge Sort (Ascending)
        mergeSort(trades, 0, trades.length - 1);
        System.out.println("Merge Sort (Ascending):");
        for (Trade t : trades) System.out.println(t);

        // Quick Sort (Descending)
        quickSort(trades, 0, trades.length - 1);
        System.out.println("\nQuick Sort (Descending):");
        for (Trade t : trades) System.out.println(t);

        // Merge two sorted lists
        Trade[] morning = {
            new Trade(100, "M1"),
            new Trade(400, "M2")
        };

        Trade[] afternoon = {
            new Trade(200, "A1"),
            new Trade(300, "A2")
        };

        mergeSort(morning, 0, morning.length - 1);
        mergeSort(afternoon, 0, afternoon.length - 1);

        Trade[] merged = mergeLists(morning, afternoon);

        System.out.println("\nMerged Trade List:");
        for (Trade t : merged) System.out.println(t);

        // Total volume
        System.out.println("\nTotal Volume: " + totalVolume(merged));
    }
}
