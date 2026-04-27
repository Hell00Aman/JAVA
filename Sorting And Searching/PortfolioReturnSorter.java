import java.util.*;

// Asset class
class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ": " + returnRate + "% (Volatility: " + volatility + ")";
    }
}

public class PortfolioReturnSorter {

    // ================= MERGE SORT (Stable, Ascending) =================
    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge step
    public static void merge(Asset[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Stable comparison (<= preserves order)
        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ================= QUICK SORT (Descending + Volatility ASC) =================
    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {

            // Random pivot selection
            int pivotIndex = low + new Random().nextInt(high - low + 1);
            swap(arr, pivotIndex, high);

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition logic
    public static int partition(Asset[] arr, int low, int high) {

        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // DESC returnRate, ASC volatility
            if (arr[j].returnRate > pivot.returnRate ||
               (arr[j].returnRate == pivot.returnRate &&
                arr[j].volatility < pivot.volatility)) {

                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap helper
    public static void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Asset[] assets = {
            new Asset("AAPL", 12, 5),
            new Asset("TSLA", 8, 9),
            new Asset("GOOG", 15, 4)
        };

        // Merge Sort (Ascending)
        mergeSort(assets, 0, assets.length - 1);
        System.out.println("Merge Sort (Ascending):");
        for (Asset a : assets) System.out.println(a);

        // Quick Sort (Descending)
        quickSort(assets, 0, assets.length - 1);
        System.out.println("\nQuick Sort (Descending):");
        for (Asset a : assets) System.out.println(a);
    }
}
