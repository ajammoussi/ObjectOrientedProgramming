import org.w3c.dom.Text;

import java.util.Objects;

public class Library {
    private static Book[] inventory;
    private static int size = 0;

    public Library(int capacity) {
        inventory = new Book[capacity];
    }

    public static void add(Book b) {
        inventory[size] = b;
        size++;
    }

    public static boolean compareBooks(Book b1, Book b2) {
        boolean test =  (b1.getAuthor().equals(b2.getAuthor())) && (b1.getTitle().equals(b2.getTitle())) && (b1.getYearOfProduction() == b2.getYearOfProduction());
        if (b1 instanceof Novel && b2 instanceof Novel)
            return test && (((Novel) b1).getGenre().equals(((Novel) b2).getGenre()));
        else if (b1 instanceof Textbook && b2 instanceof Textbook)
            return test && (((Textbook) b1).getField().equals(((Textbook) b2).getField()));
        else
            return false;
    }

    public static void remove(Book b) {
        int i;
        boolean test = false;
        for (i = 0; i < size; i++) {
            if (compareBooks(inventory[i], b)) {
                for (int j = i; j < size - 1; j++) {
                    inventory[j] = inventory[j + 1];
                }
                inventory[size - 1] = null;
                size--;
                i--;
                test = true;
                return;
            }
        }
        if (i == size && !test)
            System.out.println("Book is not found in library");
    }


    public void show() {
        System.out.println("Library's books: ");
        for (int i = 0; i < size; i++) {
            inventory[i].displayInformation();
        }
        System.out.println();
    }
}
