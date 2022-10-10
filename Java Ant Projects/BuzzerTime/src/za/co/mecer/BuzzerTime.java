package za.co.mecer;

import za.co.mecer.buzzer.Buzzer;
import za.co.mecer.impl.MonitorTime;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BuzzerTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BuzzerTime().run();
    }

    private void run() {
        MonitorTime time = new Buzzer();
        time.setBuzzerTime(5000, 3);
        time.runBuzzer();
//        new Buzzer().runBuzzer();
    }

}
