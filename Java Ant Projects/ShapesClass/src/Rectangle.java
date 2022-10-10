/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Rectangle extends Shape {

    private int length, height;

    Rectangle(int length, int height, String name) {
        super(name);
        this.length = length;
        this.height = height;
    }

    Rectangle(int length, String name) {
        super(name);
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return length * height;
    }

}
