// Java program to generate a bill for 5 shopping items
// It takes item name, quantity, and price as input
// Then calculates total for each item and grand total

import java.util.Scanner;

public class BillingCounter5Items {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arrays to store item details
        String[] itemName = new String[5];
        int[] quantity = new int[5];
        double[] price = new double[5];
        double[] total = new double[5];

        double grandTotal = 0;

        // Loop to get input for 5 items
        for (int i = 0; i < 5; i++) {

            System.out.print("Enter name of item " + (i + 1) + ": ");
            itemName[i] = sc.nextLine();

            System.out.print("Enter quantity of " + itemName[i] + ": ");
            quantity[i] = sc.nextInt();

            System.out.print("Enter price of " + itemName[i] + ": ");
            price[i] = sc.nextDouble();
            sc.nextLine(); // clear buffer

            // Calculate total for each item
            total[i] = quantity[i] * price[i];

            // Add to grand total
            grandTotal += total[i];
        }

        // Display the bill
        System.out.println("\n========== BILL ==========");
        System.out.println("Item\tQty\tPrice\tTotal");

        for (int i = 0; i < 5; i++) {
            System.out.println(itemName[i] + "\t" + quantity[i] + "\t" + price[i] + "\t" + total[i]);
        }

        System.out.println("---------------------------");
        System.out.println("Grand Total = " + grandTotal);
        System.out.println("===========================");

        sc.close();
    }
}
