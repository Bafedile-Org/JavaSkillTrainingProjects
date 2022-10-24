
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
        Shape shapes[] = {new Circle(10, "Circle"),
            new Cylinder(10, "Cylinder", 5),
            new Rectangle(10, 5, "Rectangle"),
            new Square(10, "Square"),
            new Cube(200, "Cube")};

        printShapes(shapes);
    }
    private void printShapes(Shape shapes[]){
        for(Shape shape: shapes){
            System.out.println(shape.toString()+""
                    + "\n=============================================");
        }
    }

}
