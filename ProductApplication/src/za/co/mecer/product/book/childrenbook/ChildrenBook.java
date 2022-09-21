package za.co.mecer.product.book.childrenbook;

import za.co.mecer.product.book.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ChildrenBook extends Book {

    private int age;

    public ChildrenBook(double regularPrice, String publisher, int yearPublished, int age) {
        super(regularPrice, publisher, yearPublished);
        this.age = age;
    }

}
