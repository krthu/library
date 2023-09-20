import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = createLibrary();

        library.enterLibrary();

    }

    public static Library createLibrary() {
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("Lord of The Rings", "JRR Tolkien", 1973, 3);
        Book book2 = new Book("Lord of The Two Towers", "JRR Tolkien", 1976, 4);
        Book book3 = new Book("Harry Potter and the philosphers stone", "JK Rowling", 1990, 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        Library library = new Library("Library of Alexandria", books);

        return library;
    }

}