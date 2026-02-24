// This program demonstrates creating a thread using the Runnable interface.
// The thread prints the squares of numbers from 1 to 5.

class SquareTask implements Runnable {
    // run() method contains the code executed by the thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Square of " + i + " = " + (i * i));
            try {
                Thread.sleep(500); // pause for half a second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SquareRunnable {
    // main method: program execution starts here
    public static void main(String[] args) {
        SquareTask task = new SquareTask(); // create Runnable object
        Thread t1 = new Thread(task);       // create Thread object
        
        t1.start(); // start the thread
    }
}
