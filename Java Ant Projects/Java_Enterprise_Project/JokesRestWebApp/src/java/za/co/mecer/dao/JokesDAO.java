package za.co.mecer.dao;

import java.util.List;
import za.co.mecer.joke.Joke;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface JokesDAO {

    void addJoke(Joke joke);

    List<Joke> getJokes();

    public List<Joke> readJokesFromFile();

    public void addJokesToFile(Joke joke);

    public void addJokesToDb(Joke joke);

    public List<Joke> getJokesFromDb();
}
