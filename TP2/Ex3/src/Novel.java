public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int yearOfProduction, String genre) {
        super(title, author, yearOfProduction);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void displayInformation() {
        System.out.println(title + " " + author + " " + yearOfProduction + " " + genre);
    }

}
