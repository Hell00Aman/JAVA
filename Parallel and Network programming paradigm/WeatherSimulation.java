// File: WeatherSimulation.java

import java.util.*;

// Class representing each "computer" (process simulated using threads)
class WeatherProcess extends Thread {

    private List<Integer> temperatures;

    public WeatherProcess() {
        temperatures = new ArrayList<>();
    }

    public void run() {
        Random rand = new Random();

        // Generate 5 random temperature readings (15–40)
        for (int i = 0; i < 5; i++) {
            temperatures.add(15 + rand.nextInt(26));
        }
    }

    // Getter to retrieve generated temperatures
    public List<Integer> getTemperatures() {
        return temperatures;
    }
}

public class WeatherSimulation {

    public static void main(String[] args) throws InterruptedException {

        // Create 4 threads (simulating 4 computers)
        WeatherProcess[] processes = new WeatherProcess[4];

        for (int i = 0; i < 4; i++) {
            processes[i] = new WeatherProcess();
            processes[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < 4; i++) {
            processes[i].join();
        }

        // Collect all temperature readings
        List<Integer> allTemps = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            allTemps.addAll(processes[i].getTemperatures());
        }

        // Calculate average temperature
        double sum = 0;
        for (int temp : allTemps) {
            sum += temp;
        }

        double avg = sum / allTemps.size();

        System.out.println("All Temperatures: " + allTemps);
        System.out.println("Average Temperature: " + avg);
    }
}
