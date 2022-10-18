package za.co.mecer.process;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.joke.Joke;
import za.co.mecer.service.Jokes;
import za.co.mecer.service.impl.JokesImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ProcessRequesting extends ProcessRequest {
    
    private Joke joke;
    private RequestDispatcher dispatcher;
    
    public ProcessRequesting(Joke joke) {
        this.joke = joke;
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jokes jokes = new JokesImpl();
        jokes.addJoke(joke);
//        dispatcher = request.getRequestDispatcher("jokes.jsp");
//        dispatcher.forward(request, response);
    }
    
}
