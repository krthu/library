import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name){
        this.name = name;
    }

    public  Library(String name, ArrayList<Book> books){
        this.name = name;
        this.books = books;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public Book searchBookByTitle(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book returnBook(String title){

        Book book = this.searchBookByTitle(title);

        if (book != null && !book.isAvailable()){
            book.setAvailable(true);
            return book;
        }
        return null;
    }

//    public ArrayList<Book> getAvalibleBooks(){
//        ArrayList<Book> avalibleBooks = new ArrayList<>();
//        for (Book book: books) {
//
//        }
//    }




}
