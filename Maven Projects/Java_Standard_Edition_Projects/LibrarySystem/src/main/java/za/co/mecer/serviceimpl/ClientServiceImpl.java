package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import za.co.mecer.model.Client;
import za.co.mecer.dao.impl.ClientDAOImpl;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.services.ClientService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientServiceImpl implements ClientService {

    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ClientDAOImpl clientImpl;

    /**
     *
     * @param conn
     */
    public ClientServiceImpl(Connection conn) {
        this.clientImpl = new ClientDAOImpl(conn);
    }

    /**
     *
     * @param set
     * @throws SQLException
     */
    @Override
    public void displayClient(ResultSet set) throws SQLException {

        while (set.next()) {
            System.out.println(String.format("FirstName: %S%n"
                    + "LastName: %S%n"
                    + "Identity Number: %S%n"
                    + "Home Address: %S%n"
                    + "Home Telephone Number: %s%n"
                    + "Work Telephone Number: %s%n"
                    + "Mobile Telephone Number: %s%n%n",
                    set.getString("firstName"), set.getString("lastName"),
                    set.getString("identityNum"), set.getString("address"), set.getString("homeTel"),
                    set.getString("workTel"), set.getString("mobileTel")));
        }
    }

    /**
     *
     * @return @throws IOException
     */
    @Override
    public String getAddress() throws IOException {
        System.out.println("Please enter client address: ");
        String address = reader.readLine();
        return address;
    }

    /**
     *
     * @return
     */
    @Override
    public String getClientIdentity() {
        System.out.println("Please enter client identity num: ");
        String identityNum = input.next();
        return identityNum;
    }

    /**
     *
     * @param str
     * @return
     */
    @Override
    public String getTelephone(String str) {
        System.out.println(String.format("Please enter client %s Tel: ", str));
        String tel = input.next();
        return tel;
    }

    /**
     *
     * @return @throws ClientException
     * @throws IOException
     */
    @Override
    public Client getClientDetails() throws ClientException, IOException {
        String firstName, lastName, address, homeTel, workTel, mobileTel, identityNum;
        System.out.println("Please enter client first name: ");
        firstName = input.next();
        System.out.println("Please enter client last name: ");
        lastName = input.next();
        identityNum = getClientIdentity();
        address = getAddress();
        mobileTel = getTelephone("mobile");
        homeTel = getTelephone("home");
        workTel = getTelephone("work");

        return new Client(firstName, lastName, identityNum, address, homeTel, workTel, mobileTel);
    }

    /**
     *
     * @param choice
     * @throws SQLException
     * @throws ClientException
     * @throws IOException
     */
    @Override
    public void processClientMenu(int choice) throws SQLException, ClientException, IOException {
        switch (choice) {
            case 1:
                clientImpl.addClient(getClientDetails());
                break;
            case 2:
                clientImpl.searchClient(getClientIdentity());
                clientImpl.displayClients();
                break;
            case 3:
                clientImpl.removeClient(getClientIdentity());
                break;
            case 4:
                clientImpl.changeClientAddress(getClientIdentity(), getAddress());
                break;
            case 5:
                clientImpl.changeClientHomeTel(getClientIdentity(), getTelephone("Home"));
                break;
            case 6:
                clientImpl.changeClientMobileTel(getClientIdentity(), getTelephone("Mobile"));
                break;
            case 7:
                clientImpl.changeClientWorkTel(getClientIdentity(), getTelephone("Work"));
                break;
            case 8:
                clientImpl.getAllClients();
                clientImpl.displayClients();
                break;
            default:
                System.out.println("EXITED CLIENT MENU!!!");

        }
    }
}
