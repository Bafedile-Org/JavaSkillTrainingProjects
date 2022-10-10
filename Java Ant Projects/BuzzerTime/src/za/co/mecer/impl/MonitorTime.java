package za.co.mecer.impl;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface MonitorTime {

    void setBuzzerTime(long milliseconds, int numberOfTimes);

    void runBuzzer();
}
