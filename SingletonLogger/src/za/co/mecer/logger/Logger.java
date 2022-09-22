package za.co.mecer.logger;

import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Logger {

    private static Logger logger;
    private static Scanner input;
    private String logs = "";

    private Logger() {

    }

    static {
        input = new Scanner(System.in);
        logger = new Logger();
    }

    public static Logger getInstance() {
        return logger;
    }

    public void log() {
        System.out.print("Enter what to log: ");
        logs += "\n" + input.next();
    }

    public void displayLogs() {
        System.out.println(logs);
    }
}
