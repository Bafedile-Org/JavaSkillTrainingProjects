package za.co.mecer.model;

import za.co.mecer.exceptions.ClientException;
import za.co.mecer.Clients;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Client implements Clients {

    private String identityNum, firstName, lastName, address, homeTel, workTel, mobileTel;
    private int clientId;

    public Client(int clientId, String firstName, String lastName, String identityNum,
            String address, String homeTel, String workTel, String mobileTel) throws ClientException {
        setIdentityNum(identityNum);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setHomeTel(homeTel);
        setMobileTel(mobileTel);
        setWorkTel(workTel);
        setClientId(clientId);
    }

    public Client(String firstName, String lastName, String identityNum,
            String address, String homeTel, String workTel, String mobileTel) throws ClientException {
        setIdentityNum(identityNum);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setHomeTel(homeTel);
        setMobileTel(mobileTel);
        setWorkTel(workTel);
    }

    @Override
    public void setFirstName(String firstName) throws ClientException {
        if (!checkNameLength(firstName)) {
            throw new ClientException(NAME_ERROR_MSG);
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) throws ClientException {
        if (!checkNameLength(lastName)) {
            throw new ClientException(NAME_ERROR_MSG);
        }
        this.lastName = lastName;
    }

    @Override
    public void setIdentityNum(String identityNum) throws ClientException {
        if (!checkIdentityNumLength(identityNum)) {
            throw new ClientException(ID_ERROR_MSG);
        }
        this.identityNum = identityNum;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setHomeTel(String homeTel) throws ClientException {
        if (!checkTelLength(homeTel)) {
            throw new ClientException(TEL_ERROR_MSG);
        }
        this.homeTel = homeTel;
    }

    @Override
    public void setWorkTel(String workTel) throws ClientException {
        if (!checkTelLength(workTel)) {
            throw new ClientException(TEL_ERROR_MSG);
        }
        this.workTel = workTel;
    }

    @Override
    public void setMobileTel(String mobileTel) throws ClientException {
        if (!checkTelLength(mobileTel)) {
            throw new ClientException(TEL_ERROR_MSG);
        }
        this.mobileTel = mobileTel;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getIdentityNum() {
        return identityNum;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getHomeTel() {
        return homeTel;
    }

    @Override
    public String getWorkTel() {
        return workTel;
    }

    @Override
    public String getMobileTel() {
        return mobileTel;
    }

    @Override
    public boolean checkNameLength(String name) throws ClientException {
        return (name.length() > 0);
    }

    @Override
    public boolean checkIdentityNumLength(String identityNum) throws ClientException {
        return (identityNum.length() == 13);
    }

    @Override
    public boolean checkTelLength(String homeTel) throws ClientException {
        return (homeTel.length() == 10);
    }

    @Override
    public String toString() {
        return String.format("Client Id: %d%n"
                + "FirstName: %S%n"
                + "LastName: %S%n"
                + "Identity Number: %S%n"
                + "Home Address: %S%n"
                + "Home Telephone Number: %s%n"
                + "Work Telephone Number: %s%n"
                + "Mobile Telephone Number: %s%n%n", clientId, firstName, lastName, identityNum, address, homeTel, workTel, mobileTel);
    }

    @Override
    public void setClientId(int clientId) throws ClientException {
        if (clientId < 0) {
            throw new ClientException(CLIENT_ID_ERROR_MSG);
        }
        this.clientId = clientId;
    }

    @Override
    public int getClientId() {
        return clientId;
    }
}
