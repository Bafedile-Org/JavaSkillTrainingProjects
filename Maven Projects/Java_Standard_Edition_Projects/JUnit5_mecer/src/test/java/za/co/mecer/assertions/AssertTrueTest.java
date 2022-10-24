package za.co.mecer.assertions;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import za.co.mecer.library.exception.BookNotFoundException;
import za.co.mecer.library.model.Book;
import za.co.mecer.library.service.BookService;
import za.co.mecer.library.service.impl.BookServiceImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AssertTrueTest {

    private BookService bookService;

    public AssertTrueTest() {
        setUp();
        closeUp();

    }

    @Test
    public void assertDBEmpty() {
        bookService = new BookServiceImpl();
        List<Book> bookList = bookService.books();
        assertTrue(bookList.isEmpty());
    }

    @Test
    public void assertDBNotEmpty() {
        bookService = new BookServiceImpl();
        Book book = new Book("1", "Jonny The Walking Dead", "Johnny Walker");
        bookService.addBook(book);
        List<Book> bookList = bookService.books();
        assertFalse(bookList.isEmpty(), "The Database Is empty".toUpperCase());
    }

    @Test
    public void assertNullTest() {
        Book book2 = bookService.getBookById("3");
        List<Book> bookList = bookService.books();
        assertNull(book2, "Requested Book is not  null".toUpperCase());
    }

    @Test
    public void assertNotNullTest() {
        Book book2 = bookService.getBookById("1");
        List<Book> bookList = bookService.books();
        assertNotNull(book2, "Requested Book is not  null".toUpperCase());
    }

    @Test
    public void assertEqualsBook() {
        Book requestedBook = bookService.getBookById("1");
        List<Book> bookList = bookService.books();
        assertEquals("1", requestedBook.getBookId());
        assertEquals("Jonny The Walking Dead", requestedBook.getTitle());
    }

    @Test
    public void assertEqualsBookMessageSupplier() {
        Book requestedBook = bookService.getBookById("1");
        assertEquals("Jonny The Walking Dead", requestedBook.getTitle(), () -> "The book requested's title is not equals to the title"
        );
    }

    @Test
    public void assertNotEqualsBookMessageSupplier() {
        Book requestedBook = bookService.getBookById("2");
        assertNotEquals("Jonny The Walking Dead", requestedBook.getTitle(), () -> "The book requested's title is not equals to the title"
        );
    }

    @Test
    public void assertArrayEqualsIds() {
        Book book2 = new Book("3", "Jonny's New Name Johnny", "Johnny Walker");
        bookService.addBook(book2);
        String[] actualBookIds = bookService.getBookIdsByPublisher("Johnny Walker");
        assertArrayEquals(new String[]{"1", "2", "3"}, actualBookIds);

    }

    @Test
    public void assertArrayNotEqualsIds() {
        Book book2 = new Book("3", "Jonny's New Name Johnny", "Johnny Walker");
        bookService.addBook(book2);
        String[] actualBookIds = bookService.getBookIdsByPublisher("Johnny Walker");
        assertFalse(Arrays.equals(new String[]{"1", "2"}, actualBookIds));

    }

    @Test
    @DisplayName("Checking Book Exception")
    @Disabled
    public void assertThrowsException() {
        BookNotFoundException bookNotFoundException = assertThrows(BookNotFoundException.class,
                () -> bookService.getBookByTitle("Naughty?"));

    }

    @BeforeEach
    public void setUp() {
        bookService = new BookServiceImpl();
        Book book = new Book("1", "Jonny The Walking Dead", "Johnny Walker");
        Book book1 = new Book("2", "Jonny's Journey", "Johnny Walker");
        bookService.addBook(book);
        bookService.addBook(book1);
    }

    @AfterEach()
    public void closeUp() {
        bookService = null;
    }

}
