package za.co.mecer.holidaypredict;

/**
 *
 * @author Dimakatso Sebatane
 */
public class HolidayPredict implements Runnable {

    private String holiday;

    public HolidayPredict(String holiday) {
        this.holiday = holiday;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(holiday.substring(0, 6) + "  Thread");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Thread name [%s] --> [%s]%n", Thread.currentThread().getName(), holiday);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s%n", ex.getMessage());
            }
        }
        System.out.printf("--------------------------------------%n"
                + "Thread %s DONE"
                + "%n--------------------------------------%n",
                Thread.currentThread().getName());
    }
}
