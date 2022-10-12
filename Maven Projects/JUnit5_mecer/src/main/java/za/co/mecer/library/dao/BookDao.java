package za.co.mecer.library.dao;

import java.util.List;
import za.co.mecer.library.model.Book;

/**
 *
 * @author StuartFripp
 */
public interface BookDao{
   void addBook(Book book);

   List<Book> books();

   Book getBookById(String bookId);

   String[] getBookIdsByPublisher(String publisher);

   List<String> getBookTitlesByPublisher(String publisher);

   Book getBookByTitle(String title);
}
