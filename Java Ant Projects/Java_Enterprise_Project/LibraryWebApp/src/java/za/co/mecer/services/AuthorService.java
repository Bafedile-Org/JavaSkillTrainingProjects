package za.co.mecer.services;

import java.util.List;
import za.co.mecer.modelImpl.Author;
import za.co.mecer.modelImpl.AuthorBook;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorService {

    public List<Author> getAuthors();

    public List<AuthorBook> getAuthorBooks();
//    public void displayAuthorAndBook();
}
