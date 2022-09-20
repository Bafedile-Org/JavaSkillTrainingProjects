package za.co.mecer.Cards;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Card {

    private int value;
    private String face;

    public Card(String face, int value) {
        this.setFace(face);
        this.value = value;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s %d", face, value);
    }
}
