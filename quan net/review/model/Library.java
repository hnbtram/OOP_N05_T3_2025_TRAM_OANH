import Book;
public class Library {
    private String name;
    private String address;
    private Book[] books;

    public Library(String name, String address, Book[] books) {
        this.name = name;
        this.address = address;
        this.books = books;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Book[] getBooks() {
        return books;
    }
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 328, 1);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 281, 2);
        Book[] books = {book1, book2};

        Library library = new Library("City Library", "123 Main St", books);

        System.out.println("Library Name: " + library.getName());
        System.out.println("Library Address: " + library.getAddress());
        for (Book book : library.getBooks()) {
            System.out.println("Book Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}
