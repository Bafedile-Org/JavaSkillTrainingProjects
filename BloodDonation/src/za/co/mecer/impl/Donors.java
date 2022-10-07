package za.co.mecer.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Donors extends Individuals {

    public void setMedicalReport(String medicalReport);

    public String getMedicalReport();

    public void setAddress(String address);

    public String getAddress();
}
