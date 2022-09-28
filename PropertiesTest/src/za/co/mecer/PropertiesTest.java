package za.co.mecer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PropertiesTest {

    public static void main(String[] args) {
        new PropertiesTest().propReadRun();
//        new PropertiesTest().propWriteRun();
    }

    private void propReadRun() {
        Path path = Paths.get("propFile.properties");
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
//            System.out.printf("The loaded properties%n"
//                    + "%s%n%s%n%s%n", properties.getProperty("db.url"),
//                    properties.getProperty("db.un"),
//                    properties.getProperty("db.pw"));

            String url = properties.getProperty("db.url", "8.8.8.8");
            System.out.println(url == null ? "Key does not exists" : url);

            int val = Integer.parseInt(properties.getProperty("val", "4"));
            System.out.println(val + 3);
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    private void propWriteRun() {
        Path path = Paths.get("propWrite.properties");
        try (OutputStream out = new FileOutputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.setProperty("colour", "Green");
            properties.setProperty("hue", "0xffe341");
            properties.setProperty("saturation", "0xabcdef");
            properties.store(out, "Properties added");
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }

        try (InputStream in = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(in);

            System.out.printf("Read Properties%n"
                    + "Colour: %s%n"
                    + "Hue: %s%n"
                    + "Saturation: %s%n", properties.getProperty("colour"),
                    properties.getProperty("hue"),
                    properties.getProperty("saturation"));

        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }

    }
}
