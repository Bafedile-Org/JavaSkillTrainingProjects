package za.co.mecer;

import za.co.mecer.Enumexamples.Seasons;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Enumexamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Enumexamples().run();
    }

    private void run() {
        Seasons[] seasons = Seasons.values();
        for (Seasons season : seasons) {
            System.out.printf("%s %s%n%n", season, season.getSeason());
        }
    }

    public enum Seasons {
        SUMMER("is sizzling Hot"), WINTER("is cranking down a norch"),
        SPRING("is cool"), AUTUMN("is very rainy");
        private final String seasonValue;

        private Seasons(String seasonValue) {
            this.seasonValue = seasonValue;
        }

        public String getSeason() {
            return seasonValue;
        }
    }

}
