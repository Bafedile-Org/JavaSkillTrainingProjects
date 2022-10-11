package za.co.mecer.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.impl.dao.PaymentDAO;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentDAOImpl implements PaymentDAO {

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public PaymentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addPayment(int loanId, Payment payment) throws SQLException {
        preparedStatement = conn.prepareStatement("INSERT INTO payment (loan_id,amount) VALUES(?,?)");
        preparedStatement.setInt(1, loanId);
        preparedStatement.setDouble(2, payment.getAmount());
        preparedStatement.executeUpdate();

        preparedStatement = conn.prepareStatement("UPDATE loan SET fine=?  WHERE loan_id = ?");
        preparedStatement.setDouble(1, payment.getAmount() - conn.prepareStatement(String.format("SELECT fine FROM loan WHERE loan_id = %d", loanId))
                .executeQuery().getDouble("fine"));
        preparedStatement.setInt(2, loanId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void removePayment(int loanId) throws SQLException {
        preparedStatement = conn.prepareStatement("DELETE FROM payment WHERE loanId = ?");
        preparedStatement.setInt(1, loanId);
        preparedStatement.executeUpdate();
    }

    @Override
    public ResultSet getAllPayments() throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM payment");
        result = preparedStatement.executeQuery();

        return result;
    }

    @Override
    public ResultSet getPayment(int loanId) throws SQLException {
        preparedStatement = conn.prepareStatement("SELECT * FROM payment WHERE loanId = ?");
        result = preparedStatement.executeQuery();

        return result;
    }

}
