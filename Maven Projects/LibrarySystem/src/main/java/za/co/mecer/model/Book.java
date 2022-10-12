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

    public Book(int bookId, String title, String ISBN, boolean availability, boolean access) {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        this.access = access;
        this.bookId = bookId;

    }

    public Book(String title, String ISBN, boolean availability, boolean access) {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        this.access = access;

    }

    @Override
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean getAccess() {
        return access;
    }

    @Override
    public boolean getAvailability() {
        return availability;
    }

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
