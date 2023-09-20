import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Library> librarys = new ArrayList<>();

        Library library1 = createLibrary();
        Library library2 =  createLibrary2();

        librarys.add(library1);
        librarys.add(library2);

        int input = -1;
        while (input != 0){
            System.out.println("Which library do you whant to visit?");
            for (int i = 0; i < librarys.size(); i++) {
                System.out.println((i +1) + ": " + librarys.get(i).getName());

            }
            System.out.println("0: Exit");
            try {
                input = sc.nextInt();

                if (input > 0 && input <= librarys.size()){
                    librarys.get(input -1).enterLibrary();

                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input");
            }

        }
        System.out.println("Closing program");

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

    public static Library createLibrary2() {
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("Harry potter and the order of the phonix", "JK Rowling", 1973, 3);
        Book book2 = new Book("The Djungelbook", "Rudyard Kipling", 1976, 4);
        Book book3 = new Book("Harry Potter and the philosphers stone", "JK Rowling", 1990, 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        Library library = new Library("City Library", books);

        return library;
    }

}