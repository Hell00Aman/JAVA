import transport.Car;
import racing.SportsCar;

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.showSpeed();

        SportsCar sc = new SportsCar();
        sc.displaySpeed();
    }
}
