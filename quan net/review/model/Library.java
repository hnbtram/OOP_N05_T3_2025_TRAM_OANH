

import java.util.List;
import java.util.ArrayList;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books = books;
    }

    // get book list
    public List<Book> getList() {
        return books;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Book 1", "Author 1", 100, 1);
        Book b2 = new Book("Book 2", "Author 2", 200, 2);
        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        Library library = new Library(bookList);
        System.out.println("Thu vien co " + library.getList().size() + " sach.");
        for (Book b : library.getList()) {
            System.out.println("Book: " + b.getTitle() + ", Author: " + b.getAuthor());
        }
    }
}