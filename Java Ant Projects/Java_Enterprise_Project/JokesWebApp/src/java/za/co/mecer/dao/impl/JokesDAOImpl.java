package za.co.mecer.dao.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.mecer.dao.JokesDAO;
import za.co.mecer.joke.Joke;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokesDAOImpl implements JokesDAO {

    private static List<Joke> jokes = new ArrayList<>();

    @Override
    public void addJoke(Joke joke) {
        if (joke == null) {
            return;
        }
        jokes.add(joke);
    }

    @Override
    public List<Joke> getJokes() {
        return jokes;
    }

}
