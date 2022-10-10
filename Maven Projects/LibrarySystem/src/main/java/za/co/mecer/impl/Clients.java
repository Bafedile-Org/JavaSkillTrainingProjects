package za.co.mecer.impl;

import za.co.mecer.exceptions.ClientException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Clients {

    public String TEL_ERROR_MSG = "Telephone Number Should Be 10 Digits Long!";
    public String ID_ERROR_MSG = "Identity Number Should Be 13 Digits Long!";
    public String NAME_ERROR_MSG = "Name Can Not Be Null or Empty!";

    public void setFirstName(String firstName) throws ClientException;

    public void setLastName(String lastName) throws ClientException;

    public void setIdentityNum(String identityNum) throws ClientException;

    public void setAddress(String address) throws ClientException;

    public void setHomeTel(String homeTel) throws ClientException;

    public void setWorkTel(String workTel) throws ClientException;

    public void setMobileTel(String mobileTel) throws ClientException;

    public String getFirstName();

    public String getLastName();

    public String getIdentityNum();

    public String getAddress();

    public String getHomeTel();

    public String getWorkTel();

    public String getMobileTel();

    public boolean checkNameLength(String name) throws ClientException;

    public boolean checkIdentityNumLength(String identityNum) throws ClientException;

    public boolean checkTelLength(String homeTel) throws ClientException;
}
