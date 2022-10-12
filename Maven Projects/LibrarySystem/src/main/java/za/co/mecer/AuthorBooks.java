package za.co.mecer;

import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBooks {

    public void setBookId(int bookId);

    public int getBookId();

    public int getAuthorId();

    public void setAuthorId(int authorId);

}
