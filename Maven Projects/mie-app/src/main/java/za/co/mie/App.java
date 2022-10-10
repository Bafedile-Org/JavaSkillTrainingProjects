package za.co.mie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	Connection conn;
	String url = "jdbc:mysql://localhost:3306/blood_donation_db?useSSL=false";
	String user = "mecer", password = "mecer";
	try{
		Class.forName("org.gjt.mm.mysql.Driver");

	 	conn = DriverManager.getConnection(url,user,password);
		System.out.printf("Database connected");

	}catch(SQLException | ClassNotFoundException sql){
		System.out.printf("Error: %s%n",sql.getMessage());
	}
        
    }
}
