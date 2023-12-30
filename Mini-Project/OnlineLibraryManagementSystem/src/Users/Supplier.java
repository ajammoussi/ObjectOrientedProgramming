package Users;

import Library.Book;

import java.util.ArrayList;

public class Supplier {
    static ArrayList<Book> availableBooks = new ArrayList<>();
    public static ArrayList<Book> getAvailableBooks() {

        availableBooks.add(new Book(1, "To Kill a Mockingbird", "Harper Lee", "Southern Gothic", 9));
        availableBooks.add(new Book(2, "1984", "George Orwell", "Dystopian Fiction", 10));
        availableBooks.add(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Modernist Fiction", 8));
        availableBooks.add(new Book(4, "Pride and Prejudice", "Jane Austen", "Romantic Fiction", 7));
        availableBooks.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger", "Coming-of-Age Fiction", 6));
        availableBooks.add(new Book(6, "Brave New World", "Aldous Huxley", "Dystopian Fiction", 9));
        availableBooks.add(new Book(7, "Moby-Dick", "Herman Melville", "Adventure Fiction", 8));
        availableBooks.add(new Book(8, "The Lord of the Rings", "J.R.R. Tolkien", "High Fantasy", 10));
        availableBooks.add(new Book(9, "Jane Eyre", "Charlotte Brontë", "Gothic Fiction", 7));
        availableBooks.add(new Book(10, "Fahrenheit 451", "Ray Bradbury", "Dystopian Fiction", 9));
        availableBooks.add(new Book(11, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 8));
        availableBooks.add(new Book(12, "One Hundred Years of Solitude", "Gabriel García Márquez", "Magical Realism", 9));
        availableBooks.add(new Book(13, "Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction", 7));
        availableBooks.add(new Book(14, "The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical Fiction", 8));
        availableBooks.add(new Book(15, "Anna Karenina", "Leo Tolstoy", "Realist Fiction", 7));
        availableBooks.add(new Book(16, "The Odyssey", "Homer", "Epic Poetry", 9));
        availableBooks.add(new Book(17, "Frankenstein", "Mary Shelley", "Gothic Fiction", 6));
        availableBooks.add(new Book(18, "The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction", 8));
        availableBooks.add(new Book(19, "Les Misérables", "Victor Hugo", "Historical Fiction", 7));
        availableBooks.add(new Book(20, "The War of the Worlds", "H.G. Wells", "Science Fiction", 6));
        availableBooks.add(new Book(21, "Lord of the Flies", "William Golding", "Allegorical Novel", 8));
        availableBooks.add(new Book(22, "The Grapes of Wrath", "John Steinbeck", "Realist Fiction", 9));
        availableBooks.add(new Book(23, "Slaughterhouse-Five", "Kurt Vonnegut", "Satirical Science Fiction", 8));
        availableBooks.add(new Book(24, "The Shining", "Stephen King", "Horror", 7));
        availableBooks.add(new Book(25, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", 10));
        availableBooks.add(new Book(26, "The Wind in the Willows", "Kenneth Grahame", "Children's Fiction", 7));
        availableBooks.add(new Book(27, "Dracula", "Bram Stoker", "Gothic Fiction", 9));
        availableBooks.add(new Book(28, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Detective Fiction", 8));
        availableBooks.add(new Book(29, "Wuthering Heights", "Emily Brontë", "Gothic", 5));
        availableBooks.add(new Book(30, "The Call of the Wild", "Jack London", "Adventure", 7));



        return availableBooks;
    }
}