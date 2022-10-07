package za.co.mecer.patient;

import za.co.mecer.impl.Patients;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Patient implements Patients {

    private String name, bloodGroup, disease;
    private int bloodGroupId;

    public Patient(String name, String bloodGroup, String disease) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.disease = disease;
        setBloodGroupId(bloodGroup);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBloodGroup() {
        return bloodGroup;
    }

    @Override
    public String getDisease() {
        return disease;
    }

    @Override
    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public int getBloodGroupId() {
        return bloodGroupId;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s%n", name, bloodGroupId, disease);
    }

}
