import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = createLibrary();

        String input = "";
        while (!input.equalsIgnoreCase("5")) {
            printMenu();
            input = sc.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println("What is the title?");
                    String title = sc.nextLine();

                    System.out.println("Who is the author?");
                    String author = sc.nextLine();

                    System.out.println("What is the publishing year?");
                    int publishingYear = sc.nextInt();
                    sc.nextLine();

                    System.out.println("What edition is it?");
                    int edition = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(title, author, publishingYear, edition);
                    library.addBook(book);

                }

                case "2" -> {
                    System.out.println("What is the title?");
                    String title = sc.nextLine();
                    Book foundBook = library.searchBookByTitle(title);
                    if (foundBook != null)
                        if (foundBook.isAvailable()) {
                            System.out.println(foundBook);
                            System.out.println("Do you whant to borrow it? (y/n)");
                            String borrow = sc.nextLine();
                            if (borrow.equalsIgnoreCase("y")) {
                                foundBook.loan();
                                System.out.println("You have borrowed " + foundBook.getTitle());
                            } else {
                                System.out.println("You have not borrowed the book.");
                            }
                        } else {
                            System.out.println(foundBook);
                            System.out.println("It is not avaliable right now.");
                        }

                    else {
                        System.out.println("Book not found.");
                    }
                }

                case "3" -> {
                    ArrayList<Book> books = library.getBooks();
                    for (Book book : books) {
                        if (book.isAvailable()) {
                            System.out.println();
                            System.out.println(book);
                        }
                    }
                }
                case "4" -> {
                    System.out.println("What is the title");
                    String title = sc.nextLine();
                    Book book = library.returnBook(title);
                    if (book != null){
                        System.out.println("Tack för att du lämnade tillbaka " + book.getTitle());
                     }
                    else {
                        System.out.println("Något gick fel. Boken inte återlämnad.");
                        }
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

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Add abook to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");
    }

    public static Library createLibrary(){
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("Lord of The Rings", "JRR Tolkien", 1973, 3);
        Book book2 = new Book("Lord of The Two Towers", "JRR Tolkien", 1976, 4);
        Book book3 = new Book("Harry Potter and the philosphers stone", "JK Rowling", 1990, 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        Library library = new Library("Alexandria", books);

        return library;
    }

//    public static Book searchBookByTitle(String title, ArrayList<Book> books) {
//        for (Book book : books) {
//            if (book.getTitle().equalsIgnoreCase(title)) {
//                return book;
//            }
//        }
//        return null;
//    }

}