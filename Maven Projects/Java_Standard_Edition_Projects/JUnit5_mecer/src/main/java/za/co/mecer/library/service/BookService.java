package za.co.mecer.library.service;

import java.util.List;
import za.co.mecer.library.model.Book;

/**
 *
 * @author StuartFripp
 */
public interface BookService{
  void addBook(Book book);

  List<Book> books();

  Book getBookById(String bookId);

  Book getBookByTitle(String title);

  String[] getBookIdsByPublisher(String publisher);

  List<String> getBookTitlesByPublisher(String publisher);
}
