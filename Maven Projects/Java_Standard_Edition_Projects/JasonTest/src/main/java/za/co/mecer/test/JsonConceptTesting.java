package za.co.mecer.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import za.co.mecer.model.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JsonConceptTesting {

    public static void main(String[] args) {
//        new JsonConceptTesting().run();
        new JsonConceptTesting().read();
    }

    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode person = mapper.createObjectNode();
        person.put("name", "Mr Biggles");
        person.put("age", 23);
        person.put("married", false);

        try (FileWriter writer = new FileWriter(Paths.get("person.json").toFile())) {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
            writer.write(json);
        } catch (JsonProcessingException ex) {
            System.err.println(String.format("Error: %s%n", ex.getMessage()));
        } catch (IOException ex) {
            System.out.println(String.format("Error: %s%n", "file not found"));
        }
    }

    public void read() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(Paths.get("person.json").toFile(), Person.class);
            System.out.println(person);

        } catch (JsonProcessingException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        } catch (IOException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }
}
