public abstract class Book {
    protected String title;
    protected String author;
    protected int yearOfProduction;

    public Book(String title, String author, int yearOfProduction) {
        this.title  = title;
        this.author  = author;
        this.yearOfProduction = yearOfProduction;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    abstract public void displayInformation();
}
