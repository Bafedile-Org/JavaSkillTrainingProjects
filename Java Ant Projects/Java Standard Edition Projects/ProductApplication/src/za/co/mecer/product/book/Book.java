package za.co.mecer.product.book;

import za.co.mecer.interfaces.book.BookInterface;
import za.co.mecer.product.Product;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Book extends Product implements BookInterface {

    private String publisher;
    private int yearPublished;

    public Book(double regularPrice, String publisher, int yearPublished) {
        super(regularPrice);
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

}
