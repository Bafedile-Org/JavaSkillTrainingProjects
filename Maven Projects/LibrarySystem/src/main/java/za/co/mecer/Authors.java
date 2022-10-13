package za.co.mecer;

import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.model.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Authors {

    public String NAME_ERROR_MSG = "Name Can Not Be Null OR Empty!!!";

    public void setName(String name) throws AuthorException;

    public String getName();

    public int getAuthorId();

    public void setAuthorId(int authorId) throws AuthorException;

    public Book getAuthorBook();

}
