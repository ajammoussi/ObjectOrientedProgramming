package Application;

import java.util.Scanner;

import Inventory.AppInventory;
import Users.Admin;
import Users.Customer;
import Users.Person;
import utils.*;

public class Homepage {
    public static void startApp() {
        while (true) {
            displayWelcomeMessage();

            int userTypeChoice = util.getUserChoice();

            if (userTypeChoice == 1) {
                handleCustomerActions();
            } else if (userTypeChoice == 2) {
                handleAdminActions();
            } else if (userTypeChoice == 0) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("===== Welcome to the Library Management System =====");
        System.out.println("1. Customer");
        System.out.println("2. Admin");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleCustomerActions() {
        System.out.println("Are you an existing user or a new customer?");
        System.out.println("1. Existing Customer (Sign In)");
        System.out.println("2. New Customer (Sign Up)");
        System.out.println("0. Back to Homepage");
        System.out.print("Enter your choice: ");

        int userActionChoice = util.getUserChoice();
        Customer customer;

        switch (userActionChoice) {
            case 1:
                customer = null;
                customer = (Customer) signIn("user");
                if (customer != null) {
                    customer.customerMenu();
                }
                break;
            case 2:
                customer = new Customer();
                if (signUp(customer) == 1) {
                    return;
                }
                customer.customerMenu();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void handleAdminActions() {
        System.out.println("Are you an existing admin?");
        System.out.println("1. Existing Admin (Sign In)");
        System.out.println("0. Back to Homepage");
        System.out.print("Enter your choice: ");

        int adminActionChoice = util.getUserChoice();
        Admin admin = null;

        switch (adminActionChoice) {
            case 1:
                admin = (Admin) signIn("admin");
                if (admin != null) {
                    admin.adminMenu();
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static boolean isUsernameUnique(String username) {
        if (AppInventory.getCustomers() == null) {
            return true;
        }
        for (Customer customer : AppInventory.getCustomers()) {
            if (customer.getUsername().equals(username)) {
                return false;
            }
        }

        if (AppInventory.getAdmin().getUsername().equals(username)) {
            return false;
        }

        return true;
    }

    private static boolean isUsernameExists(String enteredUsername) {
        for (Customer customer : AppInventory.getCustomers()) {
            if (customer.getUsername().equals(enteredUsername)) {
                return true;
            }
        }

        if (AppInventory.getAdmin().getUsername().equals(enteredUsername)) {
            return true;
        }


        return false;
    }

    // for user only
    public static int signUp(Person person) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String newUsername = scanner.nextLine();

        if (isUsernameUnique(newUsername)) {
            person.setUsername(newUsername);
            System.out.println("Enter your password: ");
            String newPassword = scanner.nextLine();
            person.setPassword(newPassword);
            System.out.println("Enter your first name: ");
            String newFirstName = scanner.nextLine();
            person.setFirstName(newFirstName);
            System.out.println("Enter your last name: ");
            String newLastName = scanner.nextLine();
            person.setLastName(newLastName);
            System.out.println("Enter your credit card name: ");
            String newCreditCardName = scanner.nextLine();
            ((Customer) person).setCreditCardName(newCreditCardName);
            System.out.println("Enter your credit card number: ");
            String newCreditCardNumber = scanner.nextLine();
            ((Customer) person).setCreditCardNumber(newCreditCardNumber);
            System.out.println("Enter your credit card expiration date (yyyy-MM-dd): ");
            String newCreditCardExpirationDate = scanner.nextLine();
            ((Customer) person).setCreditCardExpirationDate(newCreditCardExpirationDate);
            System.out.println("Enter your credit card security code: ");
            String newCreditCardSecurityCode = scanner.nextLine();
            ((Customer) person).setCreditCardSecurityCode(newCreditCardSecurityCode);
            person.setID(AppInventory.getCustomers().size() + 1);
            AppInventory.getCustomers().add((Customer) person);
            System.out.println("User sign up successful!");
            return 0;
        } else {
            System.out.println("Username is already taken. Please choose another username.");
            return 1;
        }
    }
    public static Person signIn(String role) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String enteredUsername = scanner.nextLine();

        if (isUsernameExists(enteredUsername)) {
            System.out.println("Enter your password: ");
            String enteredPassword = scanner.nextLine();


            if (role.equalsIgnoreCase("admin")) {
                if (enteredPassword.equals(AppInventory.getAdmin().getPassword())) {
                    System.out.println("Admin sign in successful!");
                    return AppInventory.getAdmin();
                } else {
                    System.out.println("Invalid password. Sign in failed.");
                }
            } else {
                Customer foundUser = AppInventory.searchCustomerByUsername(enteredUsername);
                if (foundUser != null && enteredPassword.equals(foundUser.getPassword())) {
                    System.out.println("User sign in successful!");
                    return foundUser;
                } else {
                    System.out.println("Invalid password. Sign in failed.");
                }
            }
        } else {
            System.out.println("Username not found. Please sign up.");
        }
        return null;
    }

}
