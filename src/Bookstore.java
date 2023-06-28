import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    List<Book> books;

    Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found: " + title);
    }

    public void displayBooks() {
        System.out.println("Books available in the bookstore:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
