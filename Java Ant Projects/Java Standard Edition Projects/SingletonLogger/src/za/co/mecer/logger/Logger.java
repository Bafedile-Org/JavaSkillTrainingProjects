package za.co.mecer.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Logger {

    private static Logger logger;
    private static Scanner input;
    private String logs = "";
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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
        logs += String.format("Logged [%s] at [[%s]]%n", input.nextLine(), LocalDateTime.now().format(df));
    }

    public void displayLogs() {
        System.out.println("\n" + logs);
    }
}
