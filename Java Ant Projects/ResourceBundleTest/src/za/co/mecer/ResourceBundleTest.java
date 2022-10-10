package za.co.mecer;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ResourceBundleTest {

    public static void main(String[] args) {
        new ResourceBundleTest().run();
    }

    private void run() {
        bundleMe();
        ArrayList<Integer> list = new ArrayList<>();

    }

    private void bundleMe() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("myFile");
        System.out.printf("Saying hello: %s%n", resourceBundle.getString("greeting"));
        Locale.setDefault(new Locale("fr", "CA"));
        resourceBundle = ResourceBundle.getBundle("myFile");
        System.out.printf("Saying hello: %s%n", resourceBundle.getString("greeting"));
        Locale.setDefault(new Locale("ms", "MY"));
        resourceBundle = ResourceBundle.getBundle("myFile");
        System.out.printf("Saying hello: %s%n", resourceBundle.getString("greeting"));

    }

}
