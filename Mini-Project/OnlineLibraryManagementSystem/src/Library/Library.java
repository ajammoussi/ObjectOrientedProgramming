package Library;

import java.util.ArrayList;
import Users.*;
import Misc.*;

public class Library {
    public static ArrayList<Book> booksInventory;
    public static ArrayList<User> users;
    public static Admin admin;
    public static LendingHistory lendingHistory;
    public static ArrayList<Event> events;

    public Library() {
        booksInventory = new ArrayList<Book>();
        users = new ArrayList<User>();
        admin = new Admin(0, "Java", "Lord");
        admin.setUsername("admin");
        admin.setPassword("adminos258");
        lendingHistory = new LendingHistory();
        events = new ArrayList<Event>();
    }

    public static User searchUser(String username) {
        for (User user : Library.users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
