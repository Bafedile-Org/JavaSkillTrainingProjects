package za.co.mecer.product.book.cartoonbook;

import za.co.mecer.product.book.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CartoonBook extends Book {

    private String characterName;

    public CartoonBook(double regularPrice, String publisher, int yearPublished, String characterName) {
        super(regularPrice, publisher, yearPublished);
        this.characterName = characterName;
    }

}
