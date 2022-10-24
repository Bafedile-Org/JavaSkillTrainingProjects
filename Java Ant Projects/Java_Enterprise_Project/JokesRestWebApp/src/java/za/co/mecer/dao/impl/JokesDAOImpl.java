package za.co.mecer.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
    private String jsonFilename = "C:\\JavaProgs\\JavaSkillTrainingProjects\\Java Ant Projects"
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
        addJokesToDb(joke);
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

}
