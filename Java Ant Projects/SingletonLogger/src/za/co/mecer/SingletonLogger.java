package za.co.mecer;

import za.co.mecer.logger.Logger;

/**
 *
 * @author Dimakatso Sebatane
 */
public class SingletonLogger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SingletonLogger().run();
    }

    private void run() {
        Logger logger = Logger.getInstance();
        logger.log();

        Logger logger2 = Logger.getInstance();
        logger2.log();

        Logger logger3 = Logger.getInstance();
        logger3.log();

        Logger logger4 = Logger.getInstance();
        logger4.log();
        logger4.displayLogs();
    }

}
