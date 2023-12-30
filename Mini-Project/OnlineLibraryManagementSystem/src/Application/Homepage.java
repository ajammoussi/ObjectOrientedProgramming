package Application;

import java.util.Scanner;
import Utils.util;
import Users.*;
import Library.Library;

public class Homepage {
    public static void startApp() {
        while (true) {
            displayWelcomeMessage();

            int userTypeChoice = util.getUserChoice();

            if (userTypeChoice == 1) {
                handleUserActions();
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
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserActions() {
        System.out.println("Are you an existing user or a new user?");
        System.out.println("1. Existing User (Sign In)");
        System.out.println("2. New User (Sign Up)");
        System.out.println("0. Back to Homepage");
        System.out.print("Enter your choice: ");

        int userActionChoice = util.getUserChoice();
        User user;

        switch (userActionChoice) {
            case 1:
                user = null;
                user = (User) signIn("user");
                if (user != null) {
                    user.userMenu();
                }
                break;
            case 2:
                user = new User();
                if (signUp(user) == 1) {
                    return;
                }
                user.userMenu();
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
        if (Library.users == null) {
            return true; // Username is unique
        }
        for (User user : Library.users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        if (Library.admin.getUsername().equals(username)) {
            return false;
        }

        return true;
    }


    private static boolean isUsernameExists(String enteredUsername) {
        for (User user : Library.users) {
            if (user.getUsername().equals(enteredUsername)) {
                return true;
            }
        }

        if (Library.admin.getUsername().equals(enteredUsername)) {
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
            person.setID(Library.users.size() + 1);
            Library.users.add((User) person);
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
                if (enteredPassword.equals(Library.admin.getPassword())) {
                    System.out.println("Admin sign in successful!");
                    return Library.admin;
                } else {
                    System.out.println("Invalid password. Sign in failed.");
                }
            } else {
                User foundUser = Library.searchUser(enteredUsername);
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
