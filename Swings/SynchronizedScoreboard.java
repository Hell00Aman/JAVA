// File: SynchronizedScoreboard.java

class Scoreboard {

    private int score = 0;

    // Synchronized method ensures only one thread updates at a time
    public synchronized void updateScore(int points) {
        score += points;
    }

    // Synchronized method to safely read score
    public synchronized int getScore() {
        return score;
    }
}

class PlayerThread extends Thread {

    private Scoreboard board;

    public PlayerThread(Scoreboard board) {
        this.board = board;
    }

    public void run() {
        // Each thread updates score
        for (int i = 0; i < 1000; i++) {
            board.updateScore(1);
        }
    }
}

public class SynchronizedScoreboard {

    public static void main(String[] args) throws InterruptedException {

        Scoreboard board = new Scoreboard();

        // Create multiple threads
        PlayerThread t1 = new PlayerThread(board);
        PlayerThread t2 = new PlayerThread(board);

        t1.start();
        t2.start();

        // Wait for threads to finish
        t1.join();
        t2.join();

        // Print final score
        System.out.println("Final Score: " + board.getScore());
    }
}
