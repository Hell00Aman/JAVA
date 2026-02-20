// Create a class that extends Thread
class NumberThread extends Thread {
    
    // Override run() method
    public void run() {
        
        // Print numbers from 1 to 10
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
            
            // Optional delay
            try {
                Thread.sleep(500); // 500 milliseconds delay
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class NumberThread {
    public static void main(String[] args) {
        
        // Create thread object
        NumberThread t = new NumberThread();
        
        // Start the thread
        t.start();
    }
}
