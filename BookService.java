
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> bookCatalog;

    public BookService(List<Book> bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookCatalog) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void displayCatalog() {
        for (Book book : bookCatalog) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        return bookCatalog.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
                .findFirst()
                .orElse(null);
    }


}
