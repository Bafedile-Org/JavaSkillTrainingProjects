package za.co.mecer.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Books {

    public void setISBN(String ISBN);

    public void setAvailability(boolean availability);

    public void setAccess(boolean access);

    public void setTitle(String title);

    public String getISBN();

    public String getTitle();

    public boolean getAccess();

    public boolean getAvailability();
}
