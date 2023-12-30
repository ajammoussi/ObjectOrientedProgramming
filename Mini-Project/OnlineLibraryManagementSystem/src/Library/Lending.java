package Library;

import Library.Book;

import java.util.ArrayList;

public class Lending {
    private int lendingID;
    private int userID;
    private ArrayList<Book> lendedBooks;
    private String lendStartDate;
    private String lendEndDate;

    public Lending(int lendingID, int userID, ArrayList<Book> lendedBooks, String lendStartDate, String lendEndDate) {
        this.lendingID = lendingID;
        this.userID = userID;
        this.lendedBooks = lendedBooks;
        this.lendStartDate = lendStartDate;
        this.lendEndDate = lendEndDate;
    }

    public int getLendingID() {
        return lendingID;
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<Book> getLendedBooks() {
        return lendedBooks;
    }

    public String getLendStartDate() {
        return lendStartDate;
    }

    public String getLendEndDate() {
        return lendEndDate;
    }

    public void lendingInformation() {
        System.out.println("Lending ID: " + lendingID);
        System.out.println("User ID: " + userID);
        System.out.println("Lended Books: ");
        for (Book book : lendedBooks) {
            book.BookInformation();
        }
        System.out.println("Lend Start Date: " + lendStartDate);
        System.out.println("Lend End Date: " + lendEndDate);
        System.out.println("===============");
    }
}
