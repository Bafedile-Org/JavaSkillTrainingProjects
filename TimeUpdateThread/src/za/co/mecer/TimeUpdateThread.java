package za.co.mecer;

import za.co.mecer.myclock.MyClock;

/**
 *
 * @author Dimakatso Sebatane
 */
public class TimeUpdateThread {

    public static void main(String[] args) {
        new TimeUpdateThread().run();
    }

    private void run() {
        new Thread(new MyClock()).start();
    }

}
