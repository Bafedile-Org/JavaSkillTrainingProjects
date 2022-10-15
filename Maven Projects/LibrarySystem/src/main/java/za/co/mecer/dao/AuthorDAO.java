package za.co.mecer.dao;

import za.co.mecer.model.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorDAO {

    public String AUTHOR_ERROR_MSG = "Either Your Connection Or The Author is Null!!!";

    public void addAuthor(Author author);

    public void removeAuthor(int authorId);

    public Author searchAuthor(String name);

    public void getAllAuthors();

    public void displayAuthors();

    public String getAuthorName(int authorId);

}
