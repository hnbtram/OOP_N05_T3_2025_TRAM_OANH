public class Book {
    private String title;
    private String author;
    private int numPages;
    private int id;

    public Book(String title, String author, int numPages, int id) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getId() {
        return id;
    }
}