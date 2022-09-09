
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class ShapesClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ShapesClass().runMe();

    }

    private void runMe() {
        Shape circle = new Circle(10, "Circle");
        System.out.printf(circle.toString());

        System.out.println("-------------------------------------------------------");

        Shape cylinder = new Cylinder(10, "Cylinder", 5);
        System.out.printf(cylinder.toString());
        System.out.println("-------------------------------------------------------");

        Shape rectangle = new Rectangle(10, 5, "Rectangle");
        System.out.printf(rectangle.toString());
        System.out.println("-------------------------------------------------------");

        Shape square = new Square(10, "Square");
        System.out.printf(square.toString());

        System.out.println("-------------------------------------------------------");

        Shape cube = new Cube(10, "Cube");
        System.out.printf(cube.toString());

    }

}
