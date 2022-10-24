package za.co.mecer.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.mecer.library.dao.BookDao;
import za.co.mecer.library.dao.impl.BookDaoImpl;
import za.co.mecer.library.model.Book;
import za.co.mecer.library.service.BookService;

/**
 *
 * @author StuartFripp
 */
public class BookServiceImpl implements BookService{
  private BookDao bookDao;

  public BookServiceImpl(){
    bookDao = new BookDaoImpl();
  }

  @Override
  public void addBook(Book book){
    if(book == null){
      return;
    }
    bookDao.addBook(book);
  }

  @Override
  public List<Book> books(){
    return bookDao.books();
  }

  @Override
  public Book getBookById(String bookId){
    return bookDao.getBookById(bookId);
  }

  @Override
  public String[] getBookIdsByPublisher(String publisher){
    if(publisher == null){
      return new String[0];
    }
    return bookDao.getBookIdsByPublisher(publisher);
  }

  @Override
  public List<String> getBookTitlesByPublisher(String publisher){
    if(publisher == null){
      return new ArrayList<>();
    }
    return bookDao.getBookTitlesByPublisher(publisher);
  }

  @Override
  public Book getBookByTitle(String title){
    return bookDao.getBookByTitle(title);
  }
}
