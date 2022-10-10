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
        setBloodGroupId(bloodGroup);
        return bloodGroupId;
    }

    @Override
    public void setBloodGroupId(String bloodGroup) {
        switch (bloodGroup.toUpperCase()) {
            case "A":
                bloodGroupId = 1;
                break;
            case "B":
                bloodGroupId = 2;
                break;
            case "AB":
                bloodGroupId = 3;
                break;
            default:
                bloodGroupId = 4;
        }
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s%n", name, bloodGroupId, disease);
    }

}
