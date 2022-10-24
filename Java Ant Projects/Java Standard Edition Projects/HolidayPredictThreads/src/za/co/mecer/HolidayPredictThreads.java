package za.co.mecer;

import za.co.mecer.holidaypredict.HolidayPredict;

/**
 *
 * @author Dimakatso Sebatane
 */
public class HolidayPredictThreads {

    public static void main(String[] args) {
        new HolidayPredictThreads().run();
    }

    private void run() {
        new Thread(new HolidayPredict("Cape Town")).start();
        new Thread(new HolidayPredict("Durban")).start();
    }

}
