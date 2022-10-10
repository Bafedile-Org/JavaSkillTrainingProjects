package za.co.mecer.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DatabaseConnection {

    private static DatabaseConnection dbConn = null;
    private static PreparedStatement preparedStatement = null;
    private static Connection conn = null;

    private DatabaseConnection() {

    }
}
