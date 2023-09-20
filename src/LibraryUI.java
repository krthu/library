//
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
public class LibraryUI {
//    Scanner sc = new Scanner(System.in);
//    private Library activeLibrary;
//
//
//    public LibraryUI (Library library){
//        this.activeLibrary = library;
//    }
//
//    public void setActiveLibrary(Library activeLibrary) {
//        this.activeLibrary = activeLibrary;
//    }
//
//    public void enterLibrary(Library library){
//        activeLibrary = library;
//        System.out.println("----------Welcome to " + activeLibrary.getName() + "----------");
//        String input = "";
//        while (!input.equalsIgnoreCase("5")) {
//            printMenu();
//            input = sc.nextLine();
//            switch (input) {
//                case "1" -> {
//                    Book book = createBookUI();
//                    activeLibrary.addBook(book);
//                }
//
//                case "2" -> {
//                    searchForBookByTitleUI();
//                }
//
//                case "3" -> {
//                    printBooks(true);
//
//                }
//                case "4" -> {
//                    returnBookUI();
//                }
//
//                case "5" -> {
//                    System.out.println("Goodbye!");
//                }
//                default -> {
//                    System.out.println("Ogiltigt menyval");
//                }
//            }
//        }
//    }
//        private Book createBookUI(){
//
//            System.out.println("What is the title?");
//            String title = sc.nextLine();
//
//            System.out.println("Who is the author?");
//            String author = sc.nextLine();
//
//            int publishingYear = getValidInt("What is the publishing year?");
//
//            int edition = getValidInt("What edition is it?");
//
//            Book book = new Book(title, author, publishingYear, edition);
//
//            return book;
//        }
//
//        private void searchForBookByTitleUI(){
//
//            System.out.println("What is the title?");
//            String title = sc.nextLine();
//            Book foundBook = activeLibrary.searchBookByTitle(title);
//            if (foundBook != null)
//                if (foundBook.isAvailable()) {
//                    System.out.println(foundBook);
//                    System.out.println("Do you whant to borrow "+ foundBook.getTitle() +"? (y/n)");
//                    String borrow = sc.nextLine();
//                    if (borrow.equalsIgnoreCase("y")) {
//                        foundBook.loan();
//                        System.out.println("You have borrowed " + foundBook.getTitle());
//                    } else {
//                        System.out.println("You have not borrowed the book.");
//                    }
//                } else {
//                    System.out.println(foundBook);
//                    System.out.println("It is not avaliable right now.");
//                }
//
//            else {
//                System.out.println("Book not found.");
//            }
//        }
//
//        private void returnBookUI(){
//            System.out.println("What is the title");
//            String title = sc.nextLine();
//            Book book = activeLibrary.returnBook(title);
//            if (book != null){
//                System.out.println("Tack för att du lämnade tillbaka " + book.getTitle());
//            }
//            else {
//                System.out.println("Något gick fel. Boken inte återlämnad.");
//            }
//        }
//
//
//        private int getValidInt(String question){
//
//            int input = 0;
//            while (true) {
//                System.out.println(question);
//                try {
//                    input = sc.nextInt();
//                    sc.nextLine();
//                    return input;
//                } catch(InputMismatchException e){
//                    sc.nextLine();
//                    System.out.println("Ogiltigt värde. Försök igen.");
//                }
//            }
//        }
//
//        private void printBooks(boolean onlyAvalible){
//            for (Book book: activeLibrary.getBooks()) {
//                if(onlyAvalible){
//                    System.out.println();
//                    if(book.isAvailable()){
//                        System.out.println(book);
//                    }
//                }else {
//                    System.out.println();
//                    System.out.println(book);
//                }
//            }
//        }
//    public void printMenu(){
//
//        System.out.println();
//        System.out.println("1. Add abook to the library");
//        System.out.println("2. Search for a book by name");
//        System.out.println("3. List all available books");
//        System.out.println("4. Return a book");
//        System.out.println("5. Quit");
//
//    }
//
}
