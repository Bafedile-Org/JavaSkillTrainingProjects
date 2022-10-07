package za.co.mecer.donor;

import za.co.mecer.impl.Donors;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Donor implements Donors {

    private String name, bloodGroup, medicalReport, address;
    private int bloodGroupId;

    public Donor(String name, String bloodGroup, String medicalReport) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.medicalReport = medicalReport;
        setBloodGroupId(bloodGroup);
    }

    @Override
    public void setMedicalReport(String medicalReport) {
        this.medicalReport = medicalReport;
    }

    @Override
    public String getMedicalReport() {
        return medicalReport;
    }

    @Override
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String getBloodGroup() {
        return bloodGroup;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s%n", name, bloodGroupId, medicalReport);
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;

    }

    @Override
    public int getBloodGroupId() {
        return bloodGroupId;
    }

}
