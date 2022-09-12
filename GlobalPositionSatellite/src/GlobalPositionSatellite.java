
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
import java.util.ArrayList;
import java.util.Scanner;
import za.co.mecer.GPS;

public class GlobalPositionSatellite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GlobalPositionSatellite().run();
    }

    private void run() {
        int choice, time;
        double x, y;
        Scanner input = new Scanner(System.in);
        GPS wayPoint;
        ArrayList<GPS> wayPoints = new ArrayList<>();

        do {
            System.out.print("Please enter the X coordinate: ");
            x = input.nextDouble();

            System.out.print("Please enter the Y coordinate: ");
            y = input.nextDouble();

            System.out.print("Please enter the time: ");
            time = input.nextInt();

            wayPoint = new GPS(x, y, time);
            wayPoints.add(wayPoint);

            System.out.println("Enter 1 to Enter more way points or 2 to exit: ");
            choice = input.nextInt();

        } while (choice == 1);

        displayHikingSummary(determineTotalDistance(wayPoints), determineAverageTime(wayPoints));
    }

    private double determineTotalDistance(ArrayList<GPS> wayPoints) {
        double finish, total = 0;

        for (GPS wayPoint : wayPoints) {
            finish = wayPoints.indexOf(wayPoint) + 1;
            if (finish < wayPoints.size()) {
               // total+=Math.sqrt(wayPoints.get((int) finish).getXCoordinate() - wayPoint.getXCoordinate());
                total += wayPoints.get((int) finish).getXCoordinate() - wayPoint.getXCoordinate();
            }
        }
        return total;
    }

    private int determineAverageTime(ArrayList<GPS> wayPoints) {
        int avgSpeed = 0;

        for (GPS wayPoint : wayPoints) {
            avgSpeed += wayPoint.getTime();
        }

        avgSpeed = (int) ((avgSpeed / 3600));

        return avgSpeed;

    }

    private void displayHikingSummary(double totalDistance, int avgSpeed) {
        System.out.printf("The hiker travelled a distance of %.2f km in %d hour(s)%n ", (totalDistance / 10), avgSpeed);
    }

}
