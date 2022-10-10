package za.co.mecer.author;

import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.impl.Authors;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Author implements Authors {

    private String name;

    public Author(String name) throws AuthorException {
        this.setName(name);
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
    public String toString() {
        return String.format("Author Name: %S%n", name);
    }
}
