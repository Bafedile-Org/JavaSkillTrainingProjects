package za.co.mecer;

import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBooks {

    public void setBookId(int bookId) throws BookException;

    public int getBookId();

    public int getAuthorId();

    public void setAuthorId(int authorId) throws AuthorException;

}
