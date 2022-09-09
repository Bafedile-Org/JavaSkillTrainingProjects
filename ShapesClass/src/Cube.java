/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Cube extends Square {

    public Cube(int length, String name) {
        super(length, name);
    }

    @Override
    public double calculateArea() {
        return 6 * Math.pow(super.getLength(), 2);
    }

}
