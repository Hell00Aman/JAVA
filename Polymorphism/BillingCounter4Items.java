// Program to generate a bill with 4 items in a shopping counter

import java.util.Scanner;

public class BillingCounter4Items {

    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Variables for item names
        String item1, item2, item3, item4;

        // Variables for quantity
        int qty1, qty2, qty3, qty4;

        // Variables for price
        double price1, price2, price3, price4;

        // Input Item 1 details
        System.out.print("Enter Item 1 name: ");
        item1 = sc.nextLine();
        System.out.print("Enter quantity: ");
        qty1 = sc.nextInt();
        System.out.print("Enter price: ");
        price1 = sc.nextDouble();
        sc.nextLine(); // clear buffer

        // Input Item 2 details
        System.out.print("Enter Item 2 name: ");
        item2 = sc.nextLine();
        System.out.print("Enter quantity: ");
        qty2 = sc.nextInt();
        System.out.print("Enter price: ");
        price2 = sc.nextDouble();
        sc.nextLine();

        // Input Item 3 details
        System.out.print("Enter Item 3 name: ");
        item3 = sc.nextLine();
        System.out.print("Enter quantity: ");
        qty3 = sc.nextInt();
        System.out.print("Enter price: ");
        price3 = sc.nextDouble();
        sc.nextLine();

        // Input Item 4 details
        System.out.print("Enter Item 4 name: ");
        item4 = sc.nextLine();
        System.out.print("Enter quantity: ");
        qty4 = sc.nextInt();
        System.out.print("Enter price: ");
        price4 = sc.nextDouble();

        // Calculate totals
        double total1 = qty1 * price1;
        double total2 = qty2 * price2;
        double total3 = qty3 * price3;
        double total4 = qty4 * price4;

        // Calculate grand total
        double grandTotal = total1 + total2 + total3 + total4;

        // Display bill
        System.out.println("\n-------- BILL --------");
        System.out.println(item1 + " x " + qty1 + " = " + total1);
        System.out.println(item2 + " x " + qty2 + " = " + total2);
        System.out.println(item3 + " x " + qty3 + " = " + total3);
        System.out.println(item4 + " x " + qty4 + " = " + total4);
        System.out.println("----------------------");
        System.out.println("Grand Total = " + grandTotal);
        System.out.println("----------------------");

        // Close scanner
        sc.close();
    }
}
