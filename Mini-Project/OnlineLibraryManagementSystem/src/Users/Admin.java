package Users;

import java.util.Scanner;
import java.util.ArrayList;
import Library.*;
import Misc.*;
import Utils.util;


public class Admin extends Person {
    private static int nextEventID = 1;

    public Admin(int ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }

    public Admin() {

    }

    public void adminInformation() {
        System.out.println("Admin ID: " + ID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("===============");
    }

    public void createEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new event: ");
        String eventName = scanner.nextLine();
        System.out.println("Enter the date of the new event (yyyy-MM-dd): ");
        String eventDate = scanner.nextLine();
        System.out.println("Enter the type of the new event: ");
        String eventType = scanner.nextLine();

        Event newEvent = new Event(generateEventID(), eventName, eventDate, eventType);
        Library.events.add(newEvent);
        System.out.println("Event created successfully!");
    }

    public void removeEvent() {
        if (Library.events.isEmpty()) {
            System.out.println("No events available to remove.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the event to remove: ");
        String eventName = scanner.nextLine();

        Event removedEvent = null;
        for (Event event : Library.events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                removedEvent = event;
                break;
            }
        }

        if (removedEvent != null) {
            Library.events.remove(removedEvent);

            for (User user : Library.users) {
                if (user.getSubscription() instanceof PremiumSubscription) {
                    user.getEvents().remove(removedEvent);
                }
            }

            System.out.println("Event removed successfully!");
        } else {
            System.out.println("The specified event was not found.");
        }
    }

    public void removeUser() {
        if (Library.users.isEmpty()) {
            System.out.println("No users available to remove.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username of the user to remove: ");
        String username = scanner.nextLine();

        User removedUser = null;
        for (User user : Library.users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                removedUser = user;
                break;
            }
        }

        if (removedUser != null) {
            Library.users.remove(removedUser);

            for (Event event : Library.events) {
                event.getParticipants().remove(removedUser);
            }

            System.out.println("User removed successfully!");
        } else {
            System.out.println("The specified user was not found.");
        }
    }

    public void listOfEvents() {
        if (Library.events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        System.out.println("List of Events:");
        for (Event event : Library.events) {
            event.eventInformation();
        }
        System.out.println("==========================");
    }

    public void listOfUsers() {
        if (Library.users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("List of Users:");
        System.out.println();
        for (User user : Library.users) {
            user.userInformation();
        }
        System.out.println("==========================");
    }

    public void viewLendingHistory() {
        Library.lendingHistory.showLendingHistory();
    }

    private int generateEventID() {
        return nextEventID++;
    }


    public void loadBooksFromSupplier() {
        ArrayList<Book> supplierBooks = Supplier.getAvailableBooks();
        if (supplierBooks == null) {
            System.out.println("No books available from the supplier for the moment.");
            return;
        }
        Library.booksInventory.addAll(supplierBooks);
        System.out.println(supplierBooks.size() + " books added to the library inventory.");
        Supplier.availableBooks.clear();
    }

    public void viewLibraryInventory() {
        if (Library.booksInventory.isEmpty()) {
            System.out.println("No books available in the library inventory.");
            return;
        }
        System.out.println("List of Books:");
        System.out.println();
        for (Book book : Library.booksInventory) {
            book.BookInformation();
        }
        System.out.println("==========================");
    }

    public void adminMenu() {
        int choice;

        do {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Create Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Remove User");
            System.out.println("4. List of Events");
            System.out.println("5. List of Users");
            System.out.println("6. View Lending History");
            System.out.println("7. Load Books from Supplier");
            System.out.println("8. View Library Inventory");
            System.out.println("9. Admin Information");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = util.getUserChoice();

            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    removeEvent();
                    break;
                case 3:
                    removeUser();
                    break;
                case 4:
                    listOfEvents();
                    break;
                case 5:
                    listOfUsers();
                    break;
                case 6:
                    viewLendingHistory();
                    break;
                case 7:
                    loadBooksFromSupplier();
                    break;
                case 8:
                    viewLibraryInventory();
                    break;
                case 9:
                    adminInformation();
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);
    }

}
