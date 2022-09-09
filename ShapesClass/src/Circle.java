
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Circle extends Shape {

    private double radius;

    Circle(double radius, String shape) {
        super(shape);
        this.radius = radius;
    }
    Circle(double radius){
        super();
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
