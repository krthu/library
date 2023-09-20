import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private String name;
    private ArrayList<Book> books;
    Scanner sc = new Scanner(System.in);

    public Library(String name) {
        this.name = name;
    }

    public Library(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void enterLibrary() {

        System.out.println("----------Welcome to " + this.name + "----------");
        String input = "";
        while (!input.equalsIgnoreCase("5")) {
            printMenu();
            input = sc.nextLine();
            switch (input) {
                case "1" -> {
                    Book book = createBookUI();
                    books.add(book);
                    System.out.println("Added " + book.getTitle() + " by " + book.getAuthor());
                }

                case "2" -> {
                    searchForBookByTitleUI();
                }

                case "3" -> {
                    printBooks(true);

                }
                case "4" -> {
                    returnBookUI();
                }

                case "5" -> {
                    System.out.println("Goodbye!");
                }
                default -> {
                    System.out.println("Ogiltigt menyval");
                }
            }
        }
    }


    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book returnBook(String title) {

        Book book = this.searchBookByTitle(title);

        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return book;
        }
        return null;
    }

    public void printMenu() {

        System.out.println();
        System.out.println("1. Add abook to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");

    }

    private Book createBookUI() {

        System.out.println("What is the title?");
        String title = sc.nextLine();

        System.out.println("Who is the author?");
        String author = sc.nextLine();

        int publishingYear = getValidInt("What is the publishing year?");

        int edition = getValidInt("What edition is it?");

        Book book = new Book(title, author, publishingYear, edition);

        return book;
    }

    private void searchForBookByTitleUI() {

        System.out.println("What is the title?");
        String title = sc.nextLine();
        Book foundBook = searchBookByTitle(title);
        if (foundBook != null)
            if (foundBook.isAvailable()) {
                borrow(foundBook);
            } else {
                System.out.println(foundBook);
                System.out.println("It is not avaliable right now.");
            }

        else {
            System.out.println("Book not found.");
        }
    }

    private void returnBookUI() {
        System.out.println("What is the title");
        String title = sc.nextLine();
        Book book = returnBook(title);
        if (book != null) {
            System.out.println("Tack för att du lämnade tillbaka " + book.getTitle());
        } else {
            System.out.println("Något gick fel. Boken inte återlämnad.");
        }
    }

    private int getValidInt(String question) {

        int input = 0;
        while (true) {
            System.out.println(question);
            try {
                input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Ogiltigt värde. Försök igen.");
            }
        }
    }

    private void printBooks(boolean onlyAvalible) {
        for (Book book : books) {
            if (onlyAvalible) {
                System.out.println();
                if (book.isAvailable()) {
                    System.out.println(book);
                }
            } else {
                System.out.println();
                System.out.println(book);
            }
        }
    }

    private void borrow(Book book) {
        System.out.println(book);
        System.out.println();
        System.out.println("Do you whant to borrow " + book.getTitle() + "?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        String borrow = "";
        while (borrow.equalsIgnoreCase("")){
            borrow = sc.nextLine();
            switch (borrow){
                case "1" ->{
                    book.loan();
                    System.out.println("You have borrowed " + book.getTitle());
                }
                case "2" -> {
                    System.out.println("You have not borrowed the book.");

                }
                default -> {
                    System.out.println("Ogiltigt val");
                    borrow = "";
            }

            }
        }
    }
}
