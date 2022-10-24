package za.co.mecer.person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Person {
    //implements Comparable<Person>, Comparator<Person> 

    private int age;
    private String name;
    private char gender;
    private double salary;

    public Person(String name, int age, char gender, double salary) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;
        return name.equals(p.getName()) && age == p.getAge();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Person Name: %S%n"
                + "Person Age: %d%n%n", getName(), getAge());
    }
//
//    @Override
//    public int compareTo(Person p) {
//        if (this.getAge() == p.getAge()) {
//            return 0;
//        }
//
//        if (this.getAge() > p.getAge()) {
//            return 1;
//        }
//
//        return -1;
//    }
//    @Override
//    public int compareTo(Person p) {
//        if (this.getName().charAt(0) == p.getName().charAt(0)) {
//            return 0;
//        }
//        if (this.getName().charAt(0) > p.getName().charAt(0)) {
//            return 1;
//        }
//
//        return -1;
//    }

//    @Override
//    public int compare(Person p1, Person p2) {
//        if (p1.getAge() == p2.getAge()) {
//            return 0;
//        }
//
//        if (p1.getAge() > p2.getAge()) {
//            return 1;
//        }
//
//        return -1;
//    }
}
