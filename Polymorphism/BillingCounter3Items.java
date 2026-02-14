import java.util.Scanner;

public class BillingCounter3Items {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare variables for item names
        String item1, item2, item3;

        // Declare variables for quantity
        int qty1, qty2, qty3;

        // Declare variables for price
        double price1, price2, price3;

        // Input Item 1 details
        System.out.print("Enter Item 1 name: ");
        item1 = sc.nextLine();

        System.out.print("Enter quantity of " + item1 + ": ");
        qty1 = sc.nextInt();

        System.out.print("Enter price of " + item1 + ": ");
        price1 = sc.nextDouble();
        sc.nextLine(); // clear buffer

        // Input Item 2 details
        System.out.print("Enter Item 2 name: ");
        item2 = sc.nextLine();

        System.out.print("Enter quantity of " + item2 + ": ");
        qty2 = sc.nextInt();

        System.out.print("Enter price of " + item2 + ": ");
        price2 = sc.nextDouble();
        sc.nextLine(); // clear buffer

        // Input Item 3 details
        System.out.print("Enter Item 3 name: ");
        item3 = sc.nextLine();

        System.out.print("Enter quantity of " + item3 + ": ");
        qty3 = sc.nextInt();

        System.out.print("Enter price of " + item3 + ": ");
        price3 = sc.nextDouble();

        // Calculate totals
        double total1 = qty1 * price1;
        double total2 = qty2 * price2;
        double total3 = qty3 * price3;

        // Calculate grand total
        double grandTotal = total1 + total2 + total3;

        // Display the bill
        System.out.println("\n---------- BILL ----------");
        System.out.println(item1 + " x " + qty1 + " = " + total1);
        System.out.println(item2 + " x " + qty2 + " = " + total2);
        System.out.println(item3 + " x " + qty3 + " = " + total3);
        System.out.println("--------------------------");
        System.out.println("Grand Total = " + grandTotal);
        System.out.println("--------------------------");

        sc.close(); // close scanner
    }
}
