import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Balance set to 0.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance is " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance is " + balance);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class ATMMachine {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATMMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void startATM() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\nATM Interface:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}

public class TaskThree {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // i set initial bank account balanace as 1000/= 
        ATMMachine atmMachine = new ATMMachine(account);
        atmMachine.startATM();
    }
}
