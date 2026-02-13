// This program generates a bill for 2 shopping items

import java.util.Scanner;

public class BillingCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input for Item 1
        System.out.print("Enter Item 1 name: ");
        String item1 = sc.nextLine();

        System.out.print("Enter quantity of " + item1 + ": ");
        int qty1 = sc.nextInt();

        System.out.print("Enter price of " + item1 + ": ");
        double price1 = sc.nextDouble();
        sc.nextLine(); // clear buffer

        // Input for Item 2
        System.out.print("Enter Item 2 name: ");
        String item2 = sc.nextLine();

        System.out.print("Enter quantity of " + item2 + ": ");
        int qty2 = sc.nextInt();

        System.out.print("Enter price of " + item2 + ": ");
        double price2 = sc.nextDouble();

        // Calculations
        double total1 = qty1 * price1;
        double total2 = qty2 * price2;
        double grandTotal = total1 + total2;

        // Bill Output
        System.out.println("\n------- BILL -------");
        System.out.println(item1 + " x " + qty1 + " = " + total1);
        System.out.println(item2 + " x " + qty2 + " = " + total2);
        System.out.println("--------------------");
        System.out.println("Total Amount = " + grandTotal);
        System.out.println("--------------------");

        sc.close();
    }
}
