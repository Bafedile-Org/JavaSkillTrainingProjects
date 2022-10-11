package za.co.mecer.author;

import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.impl.Authors;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Author implements Authors {
    
    private String name, isbn;
    
    public Author(String name, String isbn) throws AuthorException {
        this.setName(name);
        this.setBookISBN(isbn);
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setBookISBN(String isbn) throws AuthorException {
        this.isbn = isbn;
    }
    
    @Override
    public String getBookISBN() {
        return isbn;
    }
    
    @Override
    public String toString() {
        return String.format("Author Name: %s%n"
                + "Book ISBN Number: %s%n%n", name, isbn);
    }
}
