import java.util.Scanner;

public class TowerOfHanoiRecursive {

    // Recursive function to solve Tower of Hanoi
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Move nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of disks as input
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        System.out.println("Steps to solve Tower of Hanoi:");

        // Function call
        towerOfHanoi(n, 'A', 'B', 'C');

        sc.close();
    }
}
