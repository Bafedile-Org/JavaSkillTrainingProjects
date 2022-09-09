/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, String shape, double height) {
        super(radius, shape);
        this.setHeight(height);
    }

    void setHeight(double height) {
        this.height = height;
    }

    double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return super.calculateArea() * height;
    }
    
    

}
