package za.co.mecer.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.Map;
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

    private List<Joke> jokes = new ArrayList<>();
    private JokesQuery query;
    private String jsonFilename = "G:\\JavaSkillTrainingProjects\\Java Ant Projects"
            + "\\Java_Enterprise_Project\\JokesWebApp\\web\\assets\\jokes.json";

    public JokesDAOImpl() {
        query = new JokesQuery();

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
//        jokes = getJokesFromDb();
        jokes = readJokesFromJson();
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
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        ArrayNode arrayNode;

        ObjectNode writerNode = mapper.createObjectNode();
        List<String> jsonArray = null;
        try {
            if (!Files.readAllLines(Paths.get(jsonFilename)).isEmpty()) {
                Map<?, ?> map = mapper.readValue(Paths.get(jsonFilename).toFile(), Map.class);
                jsonArray = (List) map.get("jokes");
            }
            if (jsonArray == null) {
                arrayNode = node.arrayNode();
            } else {
                arrayNode = mapper.valueToTree(jsonArray);
            }

            node.put("category", joke.getCategory());
            node.put("joke", joke.getJoke());
            arrayNode.add(node);
            writerNode.put("jokes", arrayNode);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(writerNode);
            Files.write(Paths.get(jsonFilename), json.getBytes());
        } catch (JsonProcessingException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        } catch (IOException iox) {
            System.out.println(String.format("Error: %s%n", iox.getMessage()));
        }
    }

    public List<Joke> readJokesFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        List<String> jsonArray;
        List<Joke> jokesList = new ArrayList<>();
        ArrayNode arrayNode;

        try {
            if (!Files.readAllLines(Paths.get(jsonFilename)).isEmpty()) {
                Map<?, ?> map = mapper.readValue(Paths.get(jsonFilename).toFile(), Map.class);
                jsonArray = (List) map.get("jokes");
                arrayNode = mapper.valueToTree(jsonArray);
                for (JsonNode node : arrayNode) {

                    Joke joke = new JokeImpl(node.get("joke").toString().replaceAll("\"", ""), node.get("category").toString().replaceAll("\"", ""));
                    jokesList.add(joke);
                }
            }

        } catch (IOException iox) {
            System.out.println(String.format("Error: %s%n", iox.getMessage()));
        }
        return jokesList;
    }

}
