package za.co.mecer.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        setAttributes(request);
        dispatcher = request.getRequestDispatcher("display");
        dispatcher.forward(request, response);
    }

    public void setAttributes(HttpServletRequest request) throws ServletException, IOException {
        List<Joke> jokeList = joke.getJokes();
        List<Joke> mom = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Mom_Jokes")).collect(Collectors.toList());
        List<Joke> dad = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Dad_Jokes")).collect(Collectors.toList());
        List<Joke> monkey = jokeList.stream().filter((jo) -> jo.getCategory().equalsIgnoreCase("Monkey_Jokes")).collect(Collectors.toList());
        request.setAttribute("mom_jokes", mom);
        request.setAttribute("dad_jokes", dad);
        request.setAttribute("monkey_jokes", monkey);
    }

}
