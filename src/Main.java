import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        Book book1 = new Book("Lord of The Rings", "JRR Tolkien", 1973, 3);
        Book book2 = new Book("Lord of The Two Towers", "JRR Tolkien", 1976, 4);
        Book book3 = new Book("Harry Potter and the philosphers stone","JK Rowling", 1990, 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        System.out.println("1. Add abook to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");
        String input = "";
        while (!input.equalsIgnoreCase("5")){
            input = sc.nextLine();
            switch (input){
                case "1" -> {
                    System.out.println("What is the title?");
                    String title  = sc.nextLine();

                    System.out.println("Who is the author?");
                    String author  = sc.nextLine();

                    System.out.println("What is the publishing year?");
                    int publishingYear  = sc.nextInt();
                    sc.nextLine();

                    System.out.println("What edition is it?");
                    int edition  = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(title, author, publishingYear, edition);
                    books.add(book);

                }

                

            }

            for (Book book: books) {
                System.out.println();
                System.out.println(book);
            }


        }




    }


}