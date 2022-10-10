package za.co.mecer.interfaces.book;

import za.co.mecer.interfaces.product.ProductInterface;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookInterface extends ProductInterface {

    String getPublisher();

    void setPublisher(String publisher);

    int getYearPublished();

    void setYearPublished(int yearPublished);
}
