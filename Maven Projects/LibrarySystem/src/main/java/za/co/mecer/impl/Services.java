package za.co.mecer.impl;

import java.io.IOException;
import java.sql.SQLException;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Services {

    public int getMenuChoice();

    public void setOptionChoice(int choice) throws SQLException, ClientException, LoanException, IOException, AuthorException, PaymentException;

    public int getBookMenuChoice();

    public int getAuthorMenuChoice();

    public int getClientMenuChoice();

    public int getLoanMenuChoice();

    public int getPaymentMenuChoice();

    public void processBookMenu(int choice) throws SQLException, IOException;

    public void processAuthorMenu(int choice) throws SQLException, AuthorException;

    public void processClientMenu(int choice) throws SQLException, ClientException, IOException;

    public void processLoanMenu(int choice) throws SQLException, LoanException, ClientException, IOException;

    public void processPaymentMenu(int choice) throws SQLException, PaymentException;
}
