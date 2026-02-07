// Demonstrates encapsulation and validation in a bank account system

class BankAccount {

    // Private data members
    private String accountNumber;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String accNo, double initialBalance) {
        this.accountNumber = accNo;

        // Ensure balance is always positive
        if (initialBalance > 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        // Prevent withdrawal exceeding balance
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal request");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Creating a bank account
        BankAccount account = new BankAccount("ACC12345", 5000);

        // Performing transactions
        account.deposit(2000);
        account.withdraw(3000);

        // Displaying balance
        System.out.println("Account Balance: " + account.getBalance());
    }
}
