import java.util.Scanner;

public class ATM {
    private double balance = 1000.0;
    private String accountNumber = "23062825";
    private String pin = "2306";
    private Scanner scanner = new Scanner(System.in);
    private boolean isLoggedIn = false;

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

    public void run() {
        while (true) {
            if (!isLoggedIn) {
                login();
            } else {
                mainMenu();
            }
        }
    }

    // Login method
    public void login() {
        System.out.print("Please enter your account number: ");
        String inputAccountNumber = scanner.nextLine();

        System.out.print("Please enter your PIN: ");
        String inputPin = scanner.nextLine();

        if (inputAccountNumber.equals(accountNumber) && inputPin.equals(pin)) {
            System.out.println("Login successful!");
            isLoggedIn = true;
        } else {
            System.out.println("Invalid account number or PIN. Please try again.");
        }
    }

    // Main menu method
    public void mainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Change PIN");
        System.out.println("5. Logout");

        System.out.print("Please choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawCash();
                break;
            case 3:
                depositCash();
                break;
            case 4:
                changePin();
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Withdraw cash method
    public void withdrawCash() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }

    // Deposit cash method
    public void depositCash() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    // Change PIN method
    public void changePin() {
        System.out.print("Enter new PIN: ");
        String newPin = scanner.nextLine();
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    // Logout method
    public void logout() {
        isLoggedIn = false;
        System.out.println("You have been logged out.");
    }
}
