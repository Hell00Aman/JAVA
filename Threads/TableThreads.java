// This program creates two threads.
// One thread prints the multiplication table of 5.
// Another thread prints the multiplication table of 10.

class TableFive extends Thread {
    // run() method contains the code executed by the thread
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(500); // pause for better output visibility
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class TableTen extends Thread {
    // run() method contains the code executed by the thread
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("10 x " + i + " = " + (10 * i));
            try {
                Thread.sleep(500); // pause for better output visibility
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class TableThreads {
    // main method: starting point of the program
    public static void main(String[] args) {
        TableFive t1 = new TableFive(); // create thread for table of 5
        TableTen t2 = new TableTen();   // create thread for table of 10
        
        t1.start(); // start first thread
        t2.start(); // start second thread
    }
}
