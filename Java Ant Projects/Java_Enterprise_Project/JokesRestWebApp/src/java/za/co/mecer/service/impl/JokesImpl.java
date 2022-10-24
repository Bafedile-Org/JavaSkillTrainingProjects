package za.co.mecer.service.impl;

import java.sql.SQLException;
import java.util.List;
import za.co.mecer.dao.JokesDAO;
import za.co.mecer.dao.impl.JokesDAOImpl;
import za.co.mecer.db.DatabaseConnection;
import za.co.mecer.joke.Joke;
import za.co.mecer.service.Jokes;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokesImpl implements Jokes {

    private JokesDAO jokesDao;

    public JokesImpl() {

        jokesDao = new JokesDAOImpl();

    }

    @Override
    public void addJoke(Joke joke) {
        jokesDao.addJoke(joke);
    }

    @Override
    public List<Joke> getJokes() {
        return jokesDao.getJokes();
    }

}
