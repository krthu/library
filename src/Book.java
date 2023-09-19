public class Book {
    private String title;
    private String author;
    private int publishingYear;
    private int edition;
    private boolean isAvailable;

    public Book (String title, String author, int publishingYear, int edition){
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.edition = edition;
        this.isAvailable = true;
    }

    public String toString(){

        return "Titel: " + title + "\n" +
                "Author: " + author + "\n" +
                "Published: " + publishingYear + "\n" +
                "Edition: " + edition + "\n" +
                "Avalible: " + (isAvailable ?"Yes": "No" );

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean loan(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook(){
        if (!isAvailable){
            isAvailable = true;
            return true;
        }
        return false;
    }

}

