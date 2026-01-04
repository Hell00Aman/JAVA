// Program to print multiplication table using while loop
class MultiplicationTable {
    public static void main(String[] args) {

        int number = 5;   // Number whose table is to be printed
        int i = 1;        // Loop counter

        // While loop to print table from 1 to 10
        while (i <= 10) {
            System.out.println(number + " x " + i + " = " + (number * i));
            i++; // Increment counter
        }
    }
}
