public class Main {
    public static void main(String[] args) {
        Library library = new Library(50);

        Book b1 = new Novel("Les Misérables", "Victor Hugo", 1862, "Historical Fiction");
        Book b2 = new Textbook("Intro to ALgorithms", "Thomas H. Cormen", 1989, "Computer Science");
        Book b3 = new Novel("Macbeth", "William Shakespeare", 1580, "Drama");
        Book b4 = new Textbook("java.exe", "foulen", 2023, "POO");
        Book b5 = new Novel("The Shadow of the Wind", "Carlos Ruiz Zafón", 2001, "Mystery");
        Book b6 = new Novel("To Kill a Mockingbird", "Harper Lee", 1960, "Drama");
        Book b7 = new Textbook("Chemistry: The Central Science", "Theodore Brown", 2017, "Chemistry");

        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        library.add(b5);
        library.add(b6);
        library.add(b7);
        library.show();

        Library.remove(b4);
        library.show();

        Student s = new Student(105, "Ahmed", "GL2");
        s.setLibraryCard(new LibraryCard(5502248, "01/23", "01/24"));
        s.studentInformation();
        s.borrowBook(b1);
        s.borrowBook(b2);
        s.borrowBook(b5);
        s.show_student_books();
        library.show();
        s.returnBook(b2);
        s.show_student_books();
        library.show();


        Teacher t = new Teacher(203, "Monji", "BDD");
        t.setLibraryCard(new LibraryCard(9956204, "01/23", "01/25"));
        t.teacherInformation();
        t.borrowBook(b2);
        t.borrowBook(b6);
        t.show_teacher_books();
        library.show();
        t.returnBook(b6);
        t.show_teacher_books();
        library.show();


    }
}