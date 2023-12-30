package Library;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private String category;
    private int availableCopies;

    public Book(int bookID, String title, String author, String category, int availableCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void BookInformation() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println("===============");
    }

    public void BookInformationUser() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("===============");
    }
}
