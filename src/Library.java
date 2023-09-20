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
                    //searchForBookByTitleUI();
                    searchForBookByTermUI();

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

//                case "6" ->{
//                    System.out.println(searchForBookByTerm("Lord"));
//                }

                default -> {
                    System.out.println("Invalid optioin");
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
                borrowUI(foundBook);
            } else {
                System.out.println(foundBook);
                System.out.println("It is not avaliable right now.");
            }

        else {
            System.out.println("Book not found.");
        }
    }

    private void searchForBookByTermUI(){
        System.out.println("What is the title?");
        String title = sc.nextLine();

        ArrayList<Book> foundBooks = searchForBookByTerm(title);
        System.out.println("Found " + foundBooks.size() + " matches.");
        if (!foundBooks.isEmpty()){
            int choise = 0;
            boolean validChoise = false;
            while (!validChoise) {

                for (int i = 0; i < foundBooks.size(); i++) {
                    Book currentBook = foundBooks.get(i);
                    System.out.println((i + 1) + ": " + currentBook.getTitle() + " by " + currentBook.getAuthor());
                }
                System.out.println((foundBooks.size() + 1) + ": Cancel");
                choise = getValidInt("Choose a book");
                if(choise >= 1 && choise <= foundBooks.size()+1){
                    validChoise = true;
                }
            }
            if(choise <= foundBooks.size()) {
                borrowUI(foundBooks.get(choise - 1));
            }else {
                System.out.println("Invalid option.");
            }

        }
    }

    private ArrayList<Book> searchForBookByTerm(String title){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    private void returnBookUI() {
        System.out.println("What is the title");
        String title = sc.nextLine();
        Book book = returnBook(title);
        if (book != null) {
            System.out.println("Thank you for returning " + book.getTitle());
        } else {
            System.out.println("Something when wrong. Book not returned.");
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
                System.out.println("Has to be a integer.");
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

    private void borrowUI(Book book) {
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
