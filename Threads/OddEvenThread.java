// Thread class to print Odd numbers
class OddThread extends Thread {
    
    public void run() {
        for(int i = 1; i <= 20; i++) {
            if(i % 2 != 0) {
                System.out.println("Odd: " + i);
            }
        }
    }
}

// Thread class to print Even numbers
class EvenThread extends Thread {
    
    public void run() {
        for(int i = 1; i <= 20; i++) {
            if(i % 2 == 0) {
                System.out.println("Even: " + i);
            }
        }
    }
}

// Main class
public class OddEvenThread {
    public static void main(String[] args) {
        
        // Create thread objects
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();
        
        // Start both threads
        t1.start();
        t2.start();
    }
}
