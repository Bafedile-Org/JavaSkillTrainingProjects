package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Books {

    public String BOOK_NOT_FOUND_MSG = "Book Not Found!!!";

    public void setISBN(String ISBN);

    public void setAvailability(boolean availability);

    public void setAccess(boolean access);

    public void setTitle(String title);

    public String getISBN();

    public String getTitle();

    public boolean getAccess();

    public boolean getAvailability();
}
