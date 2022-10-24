package za.co.mecer.library.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import za.co.mecer.library.dao.BookDao;
import za.co.mecer.library.exception.BookNotFoundException;
import za.co.mecer.library.model.Book;

/**
 *
 * @author StuartFripp
 */
public class BookDaoImpl implements BookDao{
   private final List<Book> listOfBooks = new ArrayList<>();

  @Override
  public void addBook(Book book){
    listOfBooks.add(book);
  }

  @Override
  public List<Book> books(){
    return Collections.unmodifiableList(listOfBooks);
  }

  @Override
  public Book getBookById(String bookId){
    for(Book book : listOfBooks){
      if(bookId.equals(book.getBookId())){
        return book;
      }
    }
    return null;
  }

  @Override
  public String[] getBookIdsByPublisher(String publisher){
    List<String> bookIds = new ArrayList<>();
    for(Book book : listOfBooks){
      if(publisher.equals(book.getPublisher())){
        bookIds.add(book.getBookId());
      }
    }
    return bookIds.toArray(new String[bookIds.size()]);
  }

  @Override
  public List<String> getBookTitlesByPublisher(String publisher){
    List<String> bookTitles = new ArrayList<>();
    for(Book book : listOfBooks){
      if(publisher.equals(book.getPublisher())){
        bookTitles.add(book.getTitle());
      }
    }
    return bookTitles;
  }

  @Override
  public Book getBookByTitle(String title){
    for(Book book : listOfBooks){
      if(title.equals(book.getTitle())){
        return book;
      }
    }
    throw new BookNotFoundException("Book not found in Bookstore!");
  }
}
