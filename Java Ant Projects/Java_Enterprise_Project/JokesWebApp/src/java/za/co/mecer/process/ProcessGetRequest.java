package za.co.mecer.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;
import za.co.mecer.service.Jokes;
import za.co.mecer.service.impl.JokesImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProcessGetRequest extends ProcessRequest {

    private Jokes joke = new JokesImpl();
    private RequestDispatcher dispatcher;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Joke> jokeList = arrange();
        request.setAttribute("jokeList", jokeList);
        dispatcher = request.getRequestDispatcher("display");
        dispatcher.forward(request, response);
    }

    public List<Joke> arrange() {
        List<Joke> jokeList = joke.getJokes();
        List<Joke> mom = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Mom_Jokes")).collect(Collectors.toList());
        List<Joke> dad = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Dad_Jokes")).collect(Collectors.toList());
        List<Joke> monkey = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Monkey_Jokes")).collect(Collectors.toList());
        int max = Math.max(Math.max(mom.size(), monkey.size()), dad.size());
        List<Joke> all = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            if (i < mom.size()) {
                all.add(mom.get(i));
            } else {
                all.add(new JokeImpl());
            }
            if (i < dad.size()) {
                all.add(dad.get(i));
            } else {
                all.add(new JokeImpl());
            }
            if (i < monkey.size()) {
                all.add(monkey.get(i));
            } else {
                all.add(new JokeImpl());
            }
        }

        return all;
    }

}
