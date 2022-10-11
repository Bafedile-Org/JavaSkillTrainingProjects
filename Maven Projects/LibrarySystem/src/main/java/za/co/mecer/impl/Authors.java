package za.co.mecer.impl;

import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Authors {

    public void setName(String name) throws AuthorException;

    public String getName();

    public void setBookISBN(String isbn) throws AuthorException;

    public String getBookISBN();
}
