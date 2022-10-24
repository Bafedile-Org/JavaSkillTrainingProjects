package za.co.mecer.mapping;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import za.co.mecer.joke.Joke;
import za.co.mecer.service.Jokes;
import za.co.mecer.service.impl.JokesImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/jokes")
public class JokesMapping {

    @GET
    @Path("/greet")
    public String greet() {
        return "Hello there";
    }

    @GET
    public Response getJokes(@QueryParam("category") String category) {
        //  public Response getJokes() {
        Jokes jokes = new JokesImpl();
        StringBuilder sb = new StringBuilder();
        List<Joke> jokesList = jokes.getJokes();
        jokesList.stream()
                .filter(joke -> joke.getCategory().equalsIgnoreCase(category))
                .forEach(joke -> sb.append(String.format("Joke: %s%nCategory: %s%n%n", joke.getJoke(), joke.getCategory())));
        return Response.status(200).entity(sb.toString()).build();
//        return Response.status(200).entity("HEEEEELP").build();

    }
}
