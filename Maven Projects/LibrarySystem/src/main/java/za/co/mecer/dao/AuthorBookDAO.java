package za.co.mecer.dao;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBookDAO {

    public void addAuthorBook(int authorId, int bookId);

    public void removeAuthorBook(int authorId, int bookId);

    public String getBookIsbn(int bookId);

}
