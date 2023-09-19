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



}
