package za.co.mecer.library.exception;

/**
 *
 * @author StuartFripp
 */
public class BookNotFoundException extends RuntimeException{
  public BookNotFoundException(String message){
    super(message);
  }
}
