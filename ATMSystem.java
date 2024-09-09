import java.util.Scanner;

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited: " + amount);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(2000.0); // Initial balance
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}

