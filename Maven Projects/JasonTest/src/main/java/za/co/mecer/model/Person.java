package za.co.mecer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Person {

    /**
     * @return the kids
     */
    public List<Kids> getKids() {
        return kids;
    }

    /**
     * @param kids the kids to set
     */
    @JsonProperty(value = "children")
    public void setKids(List<Kids> kids) {
        this.kids = kids;
    }

    private String name;
    private Integer age;
    private Boolean married;
    private List<String> hobbies;
    private List<Kids> kids;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n"
                + "Age: %d%n"
                + "is married: %s%n"
                + "hobbies: %s%n"
                + "kids: %s%n%n", name, age, married, hobbies, getKids());
    }
}
