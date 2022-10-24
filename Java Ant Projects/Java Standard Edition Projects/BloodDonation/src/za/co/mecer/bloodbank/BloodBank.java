package za.co.mecer.bloodbank;

import za.co.mecer.exceptions.BloodBankException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BloodBank {

    private int donorId;
    private String name, address, contactNum;

    public BloodBank(String name, String address, int donorId, String contactNum) throws BloodBankException {
        this.name = name;
        this.setContactNum(contactNum);
        this.donorId = donorId;
        this.address = address;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donor) {
        this.donorId = donor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) throws BloodBankException {
        if (contactNum.length() != 10) {
            throw new BloodBankException("A contact Number should be 10 digits");
        }
        this.contactNum = contactNum;
    }

}
