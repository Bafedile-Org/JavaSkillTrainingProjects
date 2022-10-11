package za.co.mecer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.author.Author;
import za.co.mecer.book.Book;
import za.co.mecer.book.BookDAOImpl;
import za.co.mecer.client.Client;
import za.co.mecer.client.ClientDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.author.AuthorDAOImpl;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.impl.Services;
import za.co.mecer.loan.Loan;
import za.co.mecer.loan.LoanDAOImpl;
import za.co.mecer.payment.Payment;
import za.co.mecer.payment.PaymentDAOImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Service implements Services {

    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    DatabaseConnection dbConn = DatabaseConnection.getInstance();
    BookDAOImpl bookImpl;
    ClientDAOImpl clientImpl;
    LoanDAOImpl loanImpl;
    AuthorDAOImpl authorImpl;
    PaymentDAOImpl paymentImpl;

    public Service(Connection conn) throws SQLException {
        this.bookImpl = new BookDAOImpl(conn);
        this.clientImpl = new ClientDAOImpl(conn);
        this.loanImpl = new LoanDAOImpl(conn);
        this.authorImpl = new AuthorDAOImpl(conn);
        this.paymentImpl = new PaymentDAOImpl(conn);
    }

    @Override
    public int getMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {

            try {
                System.out.println("Please choose from the below\n"
                        + "1 Display Book Menu\n"
                        + "2 Display Client Menu\n"
                        + "3 Display Loan Menu\n"
                        + "4 Display Payment Menu\n"
                        + "5 Display Author Menu\n"
                        + "6 Exit\n"
                        + "Your choice: \n");
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 6);

            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);
        return choice;
    }

    @Override
    public void setOptionChoice(int choice) throws SQLException, ClientException, LoanException, IOException, AuthorException, PaymentException {
        switch (choice) {
            case 1:

                processBookMenu(getBookMenuChoice());
                break;
            case 2:
                processClientMenu(getClientMenuChoice());
                break;
            case 3:
                processLoanMenu(getLoanMenuChoice());
                break;
            case 4:
                processPaymentMenu(getPaymentMenuChoice());
                break;
            case 5:
                processAuthorMenu(getAuthorMenuChoice());
            default:
                System.out.println(String.format("%n------------------------------------------------%n"
                        + "\tTHANK YOU FOR USING OUR SERVICES%n"
                        + "------------------------------------------------%n%n"));
        }
    }

    @Override
    public int getBookMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {
            try {
                System.out.print("Choose from the below Book Menu\n"
                        + "1 Add A Book\n"
                        + "2 Get A Book\n"
                        + "3 Get Available Books\n"
                        + "4 Get Accessible Books\n"
                        + "5 Update Book Availability\n"
                        + "6 Update Book Accessibility\n"
                        + "7 Get ALL Books\n"
                        + "8 Exit Book Menu\n"
                        + "Your choice: \n");
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 8);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }

        } while (!isValid);

        return choice;

    }

    @Override
    public int getAuthorMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {
            try {
                System.out.println(String.format("Choose from the below Author Menu\n"
                        + "1 Add An Author\n"
                        + "2 Get An Author\n"
                        + "3 Remove An Author\n"
                        + "4 Get ALL Authors\n"
                        + "5 Exit Author Menu\n"
                        + "Your Choice:\n"));
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 5);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return choice;
    }

    @Override
    public int getClientMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {
            try {
                System.out.println(String.format("Choose from the below Client Menu\n"
                        + "1 Add A Client\n"
                        + "2 Get A Client\n"
                        + "3 Remove A Client\n"
                        + "4 Update Client Address\n"
                        + "5 Update Client Home Telephone Number\n"
                        + "6 Update Client Mobile Telephone Number\n"
                        + "7 Update Client Work Telephone Number\n"
                        + "8 Get ALL Clients\n"
                        + "9 Exit Client Menu\n"
                        + "Your Choice: \n"));
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 9);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return choice;
    }

    @Override
    public int getLoanMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {
            try {
                System.out.println(String.format("Choose from the below Loan Menu\n"
                        + "1 Add A Loan\n"
                        + "2 Get A Loan\n"
                        + "3 Remove A Loan\n"
                        + "4 Update Return Date\n"
                        + "5 Get All Loans\n"
                        + "6 Exit Loan Menu\n"
                        + "Your Choice:\n"));
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 6);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return choice;

    }

    @Override
    public int getPaymentMenuChoice() {
        boolean isValid;
        int choice = 0;
        do {
            try {
                System.out.println(String.format("Choose from the below Payment Menu\n"
                        + "1 Add Payment\n"
                        + "2 Get Payment\n"
                        + "3 Remove Payment\n"
                        + "4 Get All Payments\n"
                        + "5 Exit Payment Menu\n"
                        + "Your Choice: \n"));
                choice = input.nextInt();
                isValid = !(choice < 1 && choice > 5);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return choice;
    }

    @Override
    public void processBookMenu(int choice) throws SQLException, IOException {
        switch (choice) {
            case 1:
                bookImpl.addBook(getBookDetails());
                break;
            case 2:
                displayBooks(bookImpl.searchBook(getBookSearchDetails()));
                break;
            case 3:
                System.out.println("Available Books\n--------------------------------\n");
                displayBooks(bookImpl.searchAvailableBooks());
                break;
            case 4:
                System.out.println("Accessible Books\n--------------------------------\n");
                displayBooks(bookImpl.searchAccessibleBooks());
                break;
            case 5:
                bookImpl.changeBookAvailability(getBookSearchDetails(), updateBook("availability"));
                break;
            case 6:
                bookImpl.changeBookAvailability(getBookSearchDetails(), updateBook("accessibility"));
                break;
            case 7:
                displayBooks(bookImpl.getAllBooks());
                break;
            default:
                System.out.println("EXITED BOOK MENU!!");
        }
    }

    public boolean updateBook(String str) {
        System.out.println(String.format("Update Book %s(true/false): ", str));
        return input.nextBoolean();

    }

    public void displayBooks(ResultSet set) throws SQLException {

        while (set.next()) {
            System.out.println(String.format("Book title: %S%n"
                    + "Book ISBN Number: %s%n"
                    + "Book Availability: %s%n"
                    + "Book Accessibility: %s%n",
                    set.getString("title"),
                    set.getString("isbn"),
                    set.getBoolean("available"),
                    set.getBoolean("borrowable")));
        }
    }

    public Book getBookDetails() throws IOException {
        System.out.println("Please enter the book title: ");
        String title = reader.readLine();

        System.out.println("Please enter the book ISBN Number: ");
        String isbn = input.next();

        System.out.println("Please enter book accessibility(ture/false): ");
        boolean access = input.nextBoolean();
        System.out.println("Please enter book availability(ture/false): ");
        boolean available = input.nextBoolean();

        return new Book(title, isbn, available, access);

    }

    public String getBookSearchDetails() {
        System.out.println("Please enter book isbn number:");
        String isbn = input.next();

        return isbn;

    }

    @Override
    public void processAuthorMenu(int choice) throws SQLException, AuthorException {
        switch (choice) {
            case 1:
                authorImpl.addAuthor(getAuthorDetails());
                break;
            case 2:
                displayAuthor(authorImpl.searchAuthor(getAuthorName()));
                break;
            case 3:
                authorImpl.removeAuthor(getAuthorDetails());
                break;
            case 4:
                displayAuthor(authorImpl.getAllAuthors());
                break;
            default:
                System.out.println("EXITED AUTHOR MENU!!");
        }
    }

    public void displayAuthor(ResultSet set) throws SQLException {
        while (set.next()) {
            System.out.println(String.format("Author Name: %s%n"
                    + "Author's Book ID: %s%n%n", set.getString("author"), set.getString("book_id")));
        }
    }

    public String getAuthorName() {
        System.out.println("Please enter author name: ");
        String name = input.next();
        return name;
    }

    public Author getAuthorDetails() throws AuthorException {
        String name = getAuthorName();
        System.out.println("Please enter author's book isbn: ");
        String bookISBN = input.next();

        return new Author(name, bookISBN);
    }

    @Override
    public void processClientMenu(int choice) throws SQLException, ClientException, IOException {
        switch (choice) {
            case 1:
                clientImpl.addClient(getClientDetails());
                break;
            case 2:
                displayClient(clientImpl.searchClient(getClientIdentity()));
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
                displayClient(clientImpl.getAllClients());
                break;
            default:
                System.out.println("EXITED CLIENT MENU!!!");

        }
    }

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

    public String getAddress() throws IOException {
        System.out.println("Please enter client address: ");
        String address = reader.readLine();
        return address;
    }

    public String getClientIdentity() {
        System.out.println("Please enter client identity num: ");
        String identityNum = input.next();
        return identityNum;
    }

    public String getTelephone(String str) {
        System.out.println(String.format("Please enter client %s Tel: ", str));
        String tel = input.next();
        return tel;
    }

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

    @Override
    public void processLoanMenu(int choice) throws SQLException, LoanException, ClientException, IOException {
        switch (choice) {
            case 1:
                loanImpl.addLoan(getClientIdentity(), getLoanDetails());
                break;
            case 2:
                displayLoan(loanImpl.searchLoan(getLoanId()));
                break;
            case 3:
                loanImpl.removeLoan(getLoanId());
                break;
            case 4:
                loanImpl.changeReturnDate(getLoanId(), getReturnDate());
                break;
            case 5:
                displayLoan(loanImpl.getAllLoans());
                break;
            default:
                System.out.println("EXITED LOAN MENU!!!");
        }
    }

    public void displayLoan(ResultSet set) throws SQLException {
        while (set.next()) {
            System.out.println(String.format("Book borrowed date: %s%n"
                    + "Book return date: %s%n"
                    + "Book fine:  %.2f%n", set.getDate("borrowedDate"),
                    set.getDate("returnDate"), set.getDouble("fine")));
        }
    }

    public int getLoanId() {
        int loanId = 0;
        boolean isValid;
        do {
            try {
                System.out.println("Please enter loan id: ");
                loanId = input.nextInt();
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);
        return loanId;
    }

    public LocalDate getReturnDate() {
        System.out.println("Please enter return  date (dd-MM-YYYY): ");
        String returnDateString = input.next();
        LocalDate returnDate = LocalDate.of(Integer.parseInt(returnDateString.split("-")[2]),
                Integer.parseInt(returnDateString.split("-")[1]), Integer.parseInt(returnDateString.split("-")[0]));
        System.out.println(returnDate.toString());
        return returnDate;
    }

    public Loan getLoanDetails() throws LoanException {
        System.out.println("Please enter borrowed date (dd-MM-YYYY): ");
        String dateString = input.next();

        LocalDate borrowedDate = LocalDate.of(Integer.parseInt(dateString.split("-")[2]),
                Integer.parseInt(dateString.split("-")[1]), Integer.parseInt(dateString.split("-")[0]));

        LocalDate returnDate = getReturnDate();

        return new Loan(borrowedDate, returnDate, 0);
    }

    @Override
    public void processPaymentMenu(int choice) throws SQLException, PaymentException {
        switch (choice) {
            case 1:
                paymentImpl.addPayment(getLoanId(), new Payment(getPayment()));
                break;
            case 2:
                displayPayment(paymentImpl.getPayment(getLoanId()));
                break;
            case 3:
                paymentImpl.removePayment(getLoanId());
                break;
            case 4:
                displayPayment(paymentImpl.getAllPayments());
                break;
            default:
                System.out.println("EXITED PAYMENT MENU!!!");
        }

    }

    public void displayPayment(ResultSet set) throws SQLException {
        while (set.next()) {
            System.out.println(String.format("Payment Id: %d%n"
                    + "Loan Id: %d%n"
                    + "Amount paid: .2f%f%n%n", set.getInt("payment_id"), set.getInt("loan_id"), set.getDouble("amount")));
        }
    }

    public double getPayment() {
        boolean isValid;
        double amount = 0;
        do {
            try {
                System.out.println("Please enter the amount to pay for the loan");
                amount = input.nextDouble();
                isValid = !(amount < 0);
            } catch (InputMismatchException ex) {
                System.out.println(String.format("Error: %s%n", ex.getMessage()));
                isValid = false;
            }
        } while (!isValid);

        return amount;

    }

}
