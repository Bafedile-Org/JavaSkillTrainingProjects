package za.co.mecer.maintest;

import java.util.ArrayList;
import java.util.List;
import za.co.mecer.db.DatabaseConnection;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;
import za.co.mecer.service.Jokes;
import za.co.mecer.service.impl.JokesImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MainTest {

    public static void main(String[] args) {
        List<Joke> jokes;
        Joke joke = new JokeImpl("hahahahaha", "Monkey_Jokes");
        Jokes jo = new JokesImpl();
        jo.addJoke(joke);
        jokes = jo.getJokes();
        System.out.println(jokes);

    }
}
