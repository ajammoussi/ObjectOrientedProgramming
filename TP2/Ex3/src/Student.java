public class Student implements LibraryUser{
    private int ID;
    private String name;
    private String student_class;
    private Book[] books = new Book[15];
    private int size = 0;
    private LibraryCard libraryCard;

    public Student(int ID, String name, String student_class) {
        this.ID = ID;
        this.name = name;
        this.student_class = student_class;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getStudent_class() {
        return student_class;
    }

    @Override
    public void borrowBook(Book b) {
        books[size] = b;
        size++;
        Library.remove(b);
    }

    @Override
    public void returnBook(Book b) {
        int i; boolean test = false;
        for (i = 0; i < size; i++) {
            if (Library.compareBooks(books[i], b)) {
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + 1];
                }
                Library.add(b);
                books[size - 1] = null;
                size--;
                i--;
                test = true;
                return;
            }
        }
        if (i == size && !test)
            System.out.println("Book is not found in student's books");
    }

    public void show_student_books() {
        System.out.println(ID +"\'s books: ");
        for (int i = 0; i < size; i++) {
            books[i].displayInformation();
        }
        System.out.println();
    }

    public void studentInformation() {
        System.out.println(ID + " " + name + " " + student_class);
        libraryCard.cardInformation();
        System.out.println();
    }
}
