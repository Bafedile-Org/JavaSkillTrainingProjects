package za.co.mecer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MIE_StudentDBTest {

    private static Connection conn = null;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    static {
        String url, username, password;
        Path path = Paths.get("database.properties");
        try (InputStream stream = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            // Class.forName("org.gjt.mm.mysql.Driver");
            //System.out.printf("Driver Found%n");
            conn = DriverManager.getConnection(url, username, password);
            System.out.printf("Connection made to the MySQL database.%n");

        } catch (IOException | SQLException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    public static void main(String[] args) {
        new MIE_StudentDBTest().run();
    }

    private void run() {
//        int age, id;
//        String name;
        getAllFromTable();
        close();
    }

    private void addToTable(int id, String name, int age) {
        try {
            preparedStatement = conn.prepareStatement(String.format("INSERT INTO student(id,name,age) VALUES(%d,'%s',%d);", id, name, age));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
    }

    private void getAllFromTable() {
        StringBuilder sb = new StringBuilder();

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM student WHERE age >18 AND age <30 ORDER BY age");
            result = preparedStatement.executeQuery();
            while (result.next()) {
                sb.append(String.format("Name: %s%n"
                        + "Age: %d%n%n", result.getString("name"), result.getInt("age")));
            }

        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        }
        System.out.println("\n" + sb);
        closeResultSet();
    }

    private void close() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        } finally {
            System.out.printf("Prepared statement, Statement and Connection Closed!!%n");
        }
    }

    private void closeResultSet() {
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            System.out.printf("Error: %s%n", ex.getMessage());
        } finally {
            System.out.printf("Result Set Closed!!!%n");
        }
    }
}
