
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
class Car {

    private int age;
    private String model, make;

    Car() {
        this("Mecerdes-Benz", "C-Class", 29);
    }

    Car(String make, String model, int age) {
        this.setMake(make);
        this.model = model;
        this.setAge(age);
    }

    void setMake(String make) {
        this.make = make;
    }

    String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("[CAR]%n"
                + "Make: %s%n"
                + "Model: %s%n"
                + "Age: %d years old%n", this.getMake(), this.getModel(), this.getAge());
    }

}
