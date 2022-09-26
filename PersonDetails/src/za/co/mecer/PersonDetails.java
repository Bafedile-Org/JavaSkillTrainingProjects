package za.co.mecer;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PersonDetails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PersonDetails().run();
    }

    private void run() {
        ArrayList<Person> person = new ArrayList<>();

        Person p1 = new Person("Jeff Cambridge", Gender.MALE);
        p1.setBirthCertificate(LocalDate.of(1990, Month.AUGUST, 12), new Person("Jennifer Cambridge", Gender.FEMALE),
                new Person("John Cambridge", Gender.MALE), "Midrand");

        Person p2 = new Person("Liz Smith", Gender.FEMALE);
        p2.setBirthCertificate(LocalDate.of(1988, Month.APRIL, 03),
                new Person("Nathalie Smith", Gender.FEMALE), new Person("Michael Smith", Gender.MALE), "Johannesburg");

        Person p3 = new Person("Mia Daveson", Gender.FEMALE);
        p3.setBirthCertificate(LocalDate.of(1994, Month.OCTOBER, 31),
                new Person("Molly Daveson", Gender.FEMALE), new Person("Augustine Daveson", Gender.MALE), "Kimberly");
        person.add(p1);
        person.add(p2);
        person.add(p3);

        person.forEach(p -> {
            displayBirthCertificates(p);
        });

    }

    private void displayBirthCertificates(Person p) {
        System.out.printf("%s%n", p.getBirthCertificate().toString());

    }

    enum Gender {
        MALE, FEMALE
    }
}
