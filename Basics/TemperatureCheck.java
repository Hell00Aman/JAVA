import java.util.Scanner;  // Import Scanner for user input

public class TemperatureCheck350c {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the temperature
        System.out.print("Enter the current temperature in Celsius: ");
        int temperature = input.nextInt();

        // Check temperature conditions
        if (temperature > 30) {
            System.out.println("It's hot!");
        }
        else if (temperature >= 20 && temperature <= 30) {
            System.out.println("It's warm.");
        }
        else if (temperature >= 10 && temperature < 20) {
            System.out.println("It's cool.");
        }
        else {
            System.out.println("It's cold.");
        }

        // Close the Scanner
        input.close();
    }
}
