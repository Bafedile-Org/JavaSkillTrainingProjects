package za.co.mecer.organism.directions;

/**
 *
 * @author Dimakatso Sebatane
 */
public enum Directions {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    private int direction;

    private Directions(int direction) {
        this.direction = direction;
    }

    public int getDir() {
        return direction;
    }

    public void setDir(int direction) {
        this.direction = direction;
    }

}
