package za.co.mecer.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import za.co.mecer.dao.JokesDAO;
import za.co.mecer.db.query.JokesQuery;
import za.co.mecer.joke.Joke;
import za.co.mecer.joke.JokeImpl;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokesDAOImpl implements JokesDAO {

    private List<Joke> jsonJokes = new ArrayList<>();
    private List<Joke> jokes = new ArrayList<>();
    private JokesQuery query;
    private String jsonFilename = "C:\\JavaProgs\\JavaSkillTrainingProjects\\Java Ant Projects"
            + "\\Java_Enterprise_Project\\JokesWebApp\\web\\assets\\jokes.json";
    private ObjectMapper mapper;
    private ArrayNode jokesArray;

    public JokesDAOImpl() {
        query = new JokesQuery();
        mapper = new ObjectMapper();
        jokesArray = mapper.createArrayNode();

    }

    @Override
    public void addJoke(Joke joke) {
        if (joke == null) {
            return;
        }
//        addJokesToFile(joke);
//        addJokesToDb(joke);
        addJokesToJson(joke);
    }

    @Override
    public List<Joke> getJokes() {
//        jokes = readJokesFromFile();
        jokes = getJokesFromDb();
        return jokes;
    }

    @Override
    public List<Joke> readJokesFromFile() {
        List<Joke> jokesList = new ArrayList<>();
        String jo;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\JavaProgs\\JavaSkillTrainingProjects"
                + "\\Java Ant Projects\\Java_Enterprise_Project\\JokesWebApp\\web\\assets\\jokes.txt"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] arr = str.split(":");
                jo = arr[1].replace('{', ' ').replace('}', ' ');
                jokesList.add(new JokeImpl(jo, arr[0]));
            }
        } catch (IOException iox) {
        }

        return jokesList;
    }

    @Override
    public void addJokesToFile(Joke joke) {
        try (FileWriter writer = new FileWriter(new File("C:\\JavaProgs\\JavaSkillTrainingProjects\\Java Ant Projects"
                + "\\Java_Enterprise_Project\\JokesWebApp\\web\\assets\\jokes.txt"), true)) {
            writer.write(joke.toString());
            writer.write("\n");
        } catch (IOException iox) {
        }
    }

    @Override
    public void addJokesToDb(Joke joke) {
        query.addJoke(joke);
    }

    @Override
    public List<Joke> getJokesFromDb() {
        return query.getJokes();
    }

    public void addJokesToJson(Joke joke) {

        try (FileWriter writer = new FileWriter(Paths.get(jsonFilename).toFile(), true)) {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(jsonFilename));
            JSONObject jo = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jo.get("jojos");
            Iterator<Object> it = jsonArray.iterator();
            while (it.hasNext()) {
                String string = it.next().toString();
                jo = (JSONObject) it.next();
                Joke j = new JokeImpl(jo.get("category").toString(), jo.get("joke").toString());
                System.out.println(j);
            }
            jo.put("category", joke.getCategory());
            jo.put("joke", joke.getJoke());

        } catch (JsonProcessingException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        } catch (IOException iox) {
            System.out.println(String.format("Error: %s%n", iox.getMessage()));
        } catch (ParseException ex) {
            Logger.getLogger(JokesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readJokesFromJson() {
//        try {
//         
//          
//        } catch (ParseException ex) {
//            Logger.getLogger(JokesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
