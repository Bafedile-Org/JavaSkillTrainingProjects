package za.co.mecer;

import java.io.*;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ObjectStreamSerialization1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ObjectStreamSerialization1().run();
    }

    private void run() {
        File file = new File("C:\\test\\personSer.obj");
        System.out.printf("File [%s] exists? %s%n", file.getName(), file.exists());
        Person person = new Person("Decay", 34);

        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream output = new ObjectOutputStream(fos)) {
            System.out.printf("%nWriting object to file...%n%n");
            output.writeObject(person);
            output.writeObject("Hello World!");

        } catch (IOException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }

        System.out.println("Reading the object from the file...");

        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream input = new ObjectInputStream(fis)) {
            Object obj;
            while ((obj = input.readObject()) != null) {
                System.out.printf("%s%n", obj);
            }

        } catch (IOException | ClassNotFoundException iox) {
            System.out.printf("ERROR: %s%n", iox.getMessage());
        }
    }

}
