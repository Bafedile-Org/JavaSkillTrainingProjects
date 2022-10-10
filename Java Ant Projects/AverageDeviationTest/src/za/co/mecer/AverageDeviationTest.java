package za.co.mecer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AverageDeviationTest {

    /**
     * @param args the command line arguments
     */
    private double sum = 0, devSum = 0;
    private int counter = 0;

    public static void main(String[] args) {
        new AverageDeviationTest().run();
    }

    private void run() {
        double avg;
        readAvgFile();
        avg = determineAverage();
        readDeviationFile(avg);

        System.out.printf("Mean Average: %.2f%n"
                + "Standard Deviation: %.2f%n%n", avg, determineStandardDeviation());
    }

    private void readAvgFile() {
//        Path path = Paths.get("nums");
        Path path = Paths.get("c:\\test\\avgDeviationTest.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                getSum(Double.parseDouble(str));
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    private void readDeviationFile(double average) {
//        Path path = Paths.get("nums");
        Path path = Paths.get("c:\\test\\avgDeviationTest.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                getStandardDeviation(Double.parseDouble(str), average);
            }
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    private void getStandardDeviation(double num, double average) {

        devSum += Math.pow((num - average), 2);
    }

    private double determineStandardDeviation() {
        return Math.sqrt(devSum / (counter - 1));
    }

    private void getSum(double number) {
        sum += number;
        counter++;
    }

    private double determineAverage() {
        return (sum / counter);
    }

}
