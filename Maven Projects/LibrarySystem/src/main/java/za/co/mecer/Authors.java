package za.co.mecer;

import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Authors {

    public void setName(String name) throws AuthorException;

    public String getName();

    public int getAuthorId();

    public void setAuthorId(int authorId);

    public Book getAuthorBook();

}
