
class BookstoreApplication {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        bookstore.addBook(new Book("1984", "George Orwell", 1899));
        bookstore.addBook(new Book("The Da Vinci Code", "Dan Brown", 2199));
        bookstore.addBook(new Book("Amit a Dúró Dóra ledarált", "IDK", 666));

        try {
            Book book = bookstore.findBook("1984");
            System.out.println("Book found: " + book);

            book = bookstore.findBook("Harry Potter");
            System.out.println("Book found: " + book);
        } catch (BookNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }


        try {
            bookstore.sellBook("To Kill a Mockingbird", 2);
            System.out.println("Book sold successfully.");

            bookstore.sellBook("The Great Gatsby", 5);
            System.out.println("Book sold successfully.");
        } catch (BookNotFoundException | InsufficientStockException e) {
            System.out.println("Exception:" + e.getMessage());
        }

        bookstore.displayBooks();
    }
}