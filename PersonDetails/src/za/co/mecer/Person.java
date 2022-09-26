package za.co.mecer;

import java.time.LocalDate;
import za.co.mecer.PersonDetails.Gender;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Person {

    private BirthCertificate birthCert;
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        this.setName(name);
        this.setGender(gender);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setBirthCertificate(LocalDate date, Person mom, Person dad, String place) {
        this.birthCert = new BirthCertificate(date, mom, dad, place);
    }

    public BirthCertificate getBirthCertificate() {
        return birthCert;
    }

    public class BirthCertificate {

        private LocalDate date;
        private String place;
        private Person mom, dad;

        public BirthCertificate() {
        }

        public BirthCertificate(LocalDate date, Person mom, Person dad, String place) {
            this.setDate(date);
            this.setMom(mom);
            this.setDad(dad);
            this.setPlace(place);
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Person getMom() {
            return mom;
        }

        public void setMom(Person mom) {
            this.mom = mom;
        }

        public Person getDad() {
            return dad;
        }

        public void setDad(Person dad) {
            this.dad = dad;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        @Override
        public String toString() {
            return String.format("-------------------------------------------------%n"
                    + "\t\tBIRTH CERTIFICATE%n"
                    + "-------------------------------------------------%n"
                    + "NAME: %S%n"
                    + "DATE OF BIRTH: %s%n"
                    + "GENDER: %S%n"
                    + "MOTHER: %S%n"
                    + "FATHER: %S%n"
                    + "PLACE OF BIRTH: %S%n", name, date, gender, mom, dad, place);
        }

    }

    @Override
    public String toString() {
        return String.format("%S", name);
    }
}
