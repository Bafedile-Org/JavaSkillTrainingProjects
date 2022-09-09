
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public abstract class Shape {

    private String name;

    Shape() {
        this("UNKNOWN");
    }

    Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void whoAmI() {
        System.out.println("I am a Shape");
    }

    @Override
    public String toString(){
        return String.format("Shape Name is: %s%n"
                + "Area of this %s is: %.2f%n",getName(),getName(),calculateArea());
    }
    public abstract double calculateArea();
}
