package za.co.mecer;

import za.co.mecer.date.DateTest;
import za.co.mecer.test.TimeTest;
import za.co.mecer.testdatetime.DateTime;

/**
 *
 * @author Dimakatso Sebatane
 */
public class DateAndTimeExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DateAndTimeExamples().run();
    }

    private void run() {
        new DateTest().dateTest();
        new TimeTest().timeTest();
        new DateTime().testDateTime();
    }

}
