package atmIterface;
import java.util.Scanner;

class User {
    String userId;
    String pin;
    double balance;

    User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }
}

public class ATM {
    static User user = new User("shubham", "9860", 50000); // Sample user with ID, PIN, and balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the ATM!");

        // User authentication
        if (authenticateUser(scanner)) {
            displayMenu(scanner);
        } else {
            System.out.println("Authentication failed. Exiting.");
        }
    }

    public static boolean authenticateUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        String enteredUserId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        return enteredUserId.equals(user.userId) && enteredPin.equals(user.pin);
    }

    public static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawFunds(scanner);
                    break;
                case 2:
                    System.out.println("Thank you for using the ATM.....Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.....Please select a valid option.");
            }
        }
    }

    public static void withdrawFunds(Scanner scanner) {
        System.out.print("Enter the amount to withdraw:-");

        double amountToWithdraw = scanner.nextDouble();

        if (amountToWithdraw <= 0) {
            System.out.println("Invalid amount.... Please enter a positive number.");
        } else if (amountToWithdraw > user.balance) {
            System.out.println("Insufficient balance.");
        } else {
            user.balance -= amountToWithdraw;
            System.out.println("You have withdrawn: " + amountToWithdraw);
            System.out.println("Your new balance is: " + user.balance);
        }
    }
}
