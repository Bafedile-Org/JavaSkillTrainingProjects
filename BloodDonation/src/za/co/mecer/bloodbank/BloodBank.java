package za.co.mecer.bloodbank;

import za.co.mecer.donor.Donor;
import za.co.mecer.exceptions.BloodBankException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BloodBank {
    
    private Donor donor;
    private String name, address, contactNum;
    
    public BloodBank(String name, String address, Donor donor, String contactNum) throws BloodBankException {
        this.name = name;
        this.setContactNum(contactNum);
        this.donor = donor;
        this.address = address;
    }
    
    public Donor getDonor() {
        return donor;
    }
    
    public void setDonor(Donor donor) {
        this.donor = donor;
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
