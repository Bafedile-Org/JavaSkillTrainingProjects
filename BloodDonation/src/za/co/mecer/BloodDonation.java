package za.co.mecer;

import java.sql.Connection;
import za.co.mecer.dbconnection.DatabaseConnection;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BloodDonation {

    public static void main(String[] args) {
        new BloodDonation().run();
    }

    private void run() {
        DatabaseConnection dbConn = DatabaseConnection.getInstance();
        Connection conn = dbConn.getConnection();
    }
}
