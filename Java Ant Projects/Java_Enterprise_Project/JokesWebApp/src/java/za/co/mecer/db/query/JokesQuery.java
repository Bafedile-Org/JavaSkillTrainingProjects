package za.co.mecer.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.db.DatabaseConnection;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokesQuery {

    private PreparedStatement preparedStatement;
    private Connection conn;
    private ResultSet result;
    private DatabaseConnection dbCon = DatabaseConnection.getInstance();
    private final List<Joke> jokes = new ArrayList<>();

    public JokesQuery() {
        conn = dbCon.getConnection();
    }

    public void addJoke(Joke joke) {
        try {
            preparedStatement = conn.prepareStatement(String.format("INSERT INTO jokes VALUES(?,?)"));
            preparedStatement.setString(1, joke.getCategory());
            preparedStatement.setString(2, joke.getJoke());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    public void getJoke() {
        try {
            preparedStatement = conn.prepareStatement(String.format("SELECT * FROM jokes"));
            result = preparedStatement.executeQuery();
            while (result.next()) {
                addJokesToList(new JokeImpl(result.getString("joke"), result.getString("cat")));
            }
        } catch (SQLException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    public List<Joke> getJokes() {
        getJoke();
        return jokes;
    }

    private void addJokesToList(Joke joke) {
        jokes.add(joke);
    }
}
