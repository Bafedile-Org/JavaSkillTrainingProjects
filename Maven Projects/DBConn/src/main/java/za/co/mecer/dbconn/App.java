package za.co.mecer.dbconn;

/**
 *
 * @author Dimakatso Sebatane
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/blood_donation_db?useSSL=false";
        String user = "mecer", password = "mecer";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.printf("Database connected");

            ResultSet set = conn.prepareStatement("SELECT * FROM patient").executeQuery();
            while (set.next()) {
                System.out.printf("Name: %s%n"
                        + "Blood Group Id: %d%n"
                        + "Disease: %s%n%n", set.getString("name"), set.getInt("blood_group_id"), set.getString("disease"));
            }
        } catch (SQLException sql) {
            System.out.printf("Error: %s%n", sql.getMessage());
        }

    }
}
