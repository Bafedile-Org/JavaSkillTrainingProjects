package za.co.mecer.service;

import java.util.List;
import za.co.mecer.joke.Joke;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Jokes {

    void addJoke(Joke joke);

    List<Joke> getJokes();
}
