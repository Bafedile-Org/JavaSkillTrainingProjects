package za.co.mecer.Cards;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Cards {

    private int value;
    private String face;

    public Cards(String face, int value) {
        this.setFace(face);
        this.value = value;
    }

    public Cards() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
