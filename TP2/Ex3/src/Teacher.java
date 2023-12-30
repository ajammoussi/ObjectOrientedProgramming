public class Teacher implements LibraryUser {
    private int ID;
    private String name;
    private String Profession;
    private Book[] books = new Book[15];
    private int size = 0;
    private LibraryCard libraryCard;

    public Teacher(int ID, String name, String profession) {
        this.ID = ID;
        this.name = name;
        Profession = profession;
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

    public String getProfession() {
        return Profession;
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
            System.out.println("Book is not found in teacher's books");
    }

    public void show_teacher_books() {
        System.out.println(ID +"\'s books: ");
        for (int i = 0; i < size; i++) {
            books[i].displayInformation();
        }
        System.out.println();
    }

    public void teacherInformation() {
        System.out.println(ID + " " + name + " " + Profession);
        libraryCard.cardInformation();
        System.out.println();
    }
}
