package za.co.mecer.librarysystem;

import java.io.IOException;
import java.sql.SQLException;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.serviceimpl.ServiceImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LibrarySystem {

    public static void main(String[] args) {
        new LibrarySystem().run();
    }

    public void run() {
        DatabaseConnection dbConn = DatabaseConnection.getInstance();
        int choice = 0;
        do {
            try {
                ServiceImpl service = new ServiceImpl(dbConn.getConnection());
                choice = service.getMenuChoice();
                service.setOptionChoice(choice);

            } catch (SQLException | ClientException | LoanException
                    | IOException | AuthorException | PaymentException
                    | BookException | NullPointerException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        } while (choice != 6);
    }
}
