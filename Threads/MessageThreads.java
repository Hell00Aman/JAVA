// This program demonstrates multithreading in Java.
// One thread prints "Hello" five times.
// Another thread prints "Welcome" five times.

class HelloThread extends Thread {
    // run() method contains the code executed by this thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500); // pause for half a second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WelcomeThread extends Thread {
    // run() method contains the code executed by this thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Welcome");
            try {
                Thread.sleep(500); // pause for half a second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MessageThreads {
    // main method: program execution starts here
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();   // create first thread
        WelcomeThread t2 = new WelcomeThread(); // create second thread
        
        t1.start(); // start Hello thread
        t2.start(); // start Welcome thread
    }
}
