package Users;

import Library.Library;
import Misc.FreeSubscription;
import Misc.PremiumSubscription;
import Misc.SubscriptionTier;
import Users.Person;
import Utils.util;

import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import Library.*;
import Misc.*;

public class User extends Person {
    private SubscriptionTier subscription;
    private ArrayList<Book> currentBooks;
    private ArrayList<Event> events;

    public User(int ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
        currentBooks = new ArrayList<Book>();
        subscription = new FreeSubscription();
        events = new ArrayList<Event>();
    }

    public User() {
        currentBooks = new ArrayList<Book>();
        subscription = new FreeSubscription();
        events = new ArrayList<Event>();
    }

    public SubscriptionTier getSubscription() {
        return subscription;
    }

    public ArrayList<Book> getCurrentBooks() {
        return currentBooks;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void changeSubscription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Subscription: ");
        subscription.tierInformation();
        System.out.println("Choose a new subscription tier:");
        System.out.println("1. Free");
        System.out.println("2. Premium");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                subscription = new FreeSubscription();
                System.out.println("Subscription changed to Free.");
                break;
            case 2:
                subscription = new PremiumSubscription();
                System.out.println("Subscription changed to Premium.");

                if (subscription instanceof PremiumSubscription) {
                    System.out.println("Enter the start date of the Premium subscription (yyyy-MM-dd): ");
                    String startDateString = scanner.next();

                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date startDate = dateFormat.parse(startDateString);

                        // Calculate the end date (one year ahead)
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(startDate);
                        calendar.add(Calendar.YEAR, 1);
                        Date endDate = calendar.getTime();

                        String endDateString = dateFormat.format(endDate);

                        ((PremiumSubscription) subscription).setSubStartDate(startDateString);
                        ((PremiumSubscription) subscription).setSubEndDate(endDateString);

                        System.out.println("Premium subscription activated. Subscription end date: " + endDateString);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Premium subscription activation failed.");
                        subscription = new FreeSubscription(); // Revert to Free subscription on error
                    }
                }
                break;
            default:
                System.out.println("Invalid choice. Subscription remains unchanged.");
        }
    }

    public void userInformation() {
        System.out.println("User ID: " + ID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Subscription: ");
        subscription.tierInformation();
        System.out.println("Current Books: ");
        for (Book book : currentBooks) {
            book.BookInformationUser();
        }
        if (subscription instanceof PremiumSubscription) {
            System.out.println("Participated Events: ");
            for (Event event : events) {
                event.eventInformationUser();
            }
        }
        System.out.println("===============");
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Enter the number of books to borrow: ");
        int numberOfBooks = scanner.nextInt();

        if ((subscription instanceof FreeSubscription && numberOfBooks > 5) ||
                (subscription instanceof PremiumSubscription && numberOfBooks > 10)) {
            System.out.println("You can only borrow up to " +
                    (subscription instanceof FreeSubscription ? "5" : "10") + " books.");
            return;
        }

        ArrayList<Book> borrowedBooks = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter the title of book #" + (i + 1) + " to borrow: ");
            String title = scanner.next();

            Book borrowedBook = null;
            for (Book book : Library.booksInventory) {
                if (book.getTitle().equalsIgnoreCase(title) && book.getAvailableCopies() > 0) {
                    borrowedBook = book;
                    borrowedBooks.add(borrowedBook);
                    break;
                }
            }

            if (borrowedBook == null) {
                System.out.println("The specified book '" + title +
                        "' is not available in the inventory or has no available copies.");
                return;
            }
        }

        currentBooks.addAll(borrowedBooks);

        Lending newLending = new Lending(generateLendingID(), getID(),
                new ArrayList<>(borrowedBooks), getCurrentDate(), getDueDate());
        Library.lendingHistory.addLending(newLending);

        System.out.println("Books borrowed successfully!");
    }



    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book to return: ");
        String title = scanner.nextLine();

        Book returnedBook = null;
        for (Book book : currentBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                returnedBook = book;
                break;
            }
        }

        if (returnedBook != null) {
            returnedBook.setAvailableCopies(returnedBook.getAvailableCopies() + 1);
            currentBooks.remove(returnedBook);

            System.out.println("Book returned successfully!");
        } else {
            System.out.println("The specified book is not currently borrowed by the user.");
        }
    }
    public void participateEvents() {
        if (subscription instanceof PremiumSubscription) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("List of Events:");
            for (Event event : Library.events) {
                event.eventInformation();
            }

            System.out.println("Enter the name of the event to participate: ");
            String eventName = scanner.nextLine();

            Event selectedEvent = null;
            for (Event event : Library.events) {
                if (event.getEventName().equalsIgnoreCase(eventName)) {
                    selectedEvent = event;
                    break;
                }
            }

            if (selectedEvent != null) {
                selectedEvent.getParticipants().add(this);
                System.out.println("You have successfully participated in the event: " + selectedEvent.getEventName());
                events.add(selectedEvent);
            } else {
                System.out.println("The specified event was not found.");
            }
        } else {
            System.out.println("Only premium users can participate in events. Please upgrade your subscription.");
        }
    }

    private int generateLendingID() {
        return Library.lendingHistory.getLendings().size() + 1;
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    private String getDueDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 14); // 14 days from the current date
        Date dueDate = calendar.getTime();
        return dateFormat.format(dueDate);
    }

    public void deleteAccount() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter your username: ");
    	String username = scanner.nextLine();
    	System.out.println("Enter your password: ");
    	String password = scanner.nextLine();
    	if (username.equals(this.username) && password.equals(this.password)) {
    		Library.admin.removeUser();
    		System.out.println("Your account has been deleted.");
    	}
    	else {
    		System.out.println("Your username or password is incorrect.");
    	}
    }

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome, " + firstName + " " + lastName + "!");

        do {
            System.out.println("===== User Menu =====");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Change Subscription");
            System.out.println("4. Participate in Events");
            System.out.println("5. View User Information");
            System.out.println("6. Delete Account");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = util.getUserChoice();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    changeSubscription();
                    break;
                case 4:
                    participateEvents();
                    break;
                case 5:
                    userInformation();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 0:
                    System.out.println("Exiting User Menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);
    }

}
