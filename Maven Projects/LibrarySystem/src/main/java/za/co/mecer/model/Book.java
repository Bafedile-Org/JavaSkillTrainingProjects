package za.co.mecer.model;

import za.co.mecer.Books;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Book implements Books {

    private String ISBN, title;
    private boolean availability, access;
    private int bookId;

    /**
     *
     * @param bookId
     * @param title
     * @param ISBN
     * @param availability
     * @param access
     */
    public Book(int bookId, String title, String ISBN, boolean availability, boolean access) {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        this.access = access;
        this.bookId = bookId;

    }

    /**
     *
     * @param title
     * @param ISBN
     * @param availability
     * @param access
     */
    public Book(String title, String ISBN, boolean availability, boolean access) {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        this.access = access;

    }

    /**
     *
     * @param ISBN
     */
    @Override
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     *
     * @param availability
     */
    @Override
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     *
     * @param access
     */
    @Override
    public void setAccess(boolean access) {
        this.access = access;
    }

    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    @Override
    public String getISBN() {
        return ISBN;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean getAccess() {
        return access;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean getAvailability() {
        return availability;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Book title: %S%n"
                + "Book ISBN Number: %s%n"
                + "Book Availability: %s%n"
                + "Book Accessibility: %s%n", title, ISBN, availability, access);
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}
