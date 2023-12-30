public class Textbook extends Book{
    private String field;

    public Textbook(String title, String author, int yearOfProduction, String field) {
        super(title, author, yearOfProduction);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void displayInformation() {
        System.out.println(title + " " + author + " " + yearOfProduction + " " + field);
    }
}
