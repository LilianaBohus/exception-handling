import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {
    Map<Book, Integer> books;

    Bookstore() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book, 1);
    }

    public void addBookWithQuantity(Book book, int quantity) {
        books.put(book, quantity);
    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Book book : books.keySet()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found: " + title);
    }

    public void sellBook(String title, int quantity) throws InsufficientStockException, BookNotFoundException {
        Book book = findBook(title);
        if (!books.containsKey(book) || books.get(book) < quantity) {
            throw new InsufficientStockException("Insufficient stock for book: " + title);
        } else {
            int remainingQuantity = books.get(book) - quantity;
            books.put(book, remainingQuantity);
        }
    }

    public void displayBooks() {
        System.out.println("Books available in the bookstore:");
        for (Book book : books.keySet()) {
            System.out.println(book);
        }
    }
}
