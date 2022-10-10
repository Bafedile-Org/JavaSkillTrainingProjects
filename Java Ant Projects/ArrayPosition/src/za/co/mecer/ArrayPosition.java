package za.co.mecer;

import java.util.Arrays;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ArrayPosition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ArrayPosition().run();
    }

    private void run() {

        PositionArr pos = (array, str) -> {
            int arr[] = new int[(array.length / 2) + 1];
            if (str.equalsIgnoreCase("even")) {
                int j = 0;
                for (int i = 0; i < array.length; i++) {
                    if (((i + 1) % 2) == 0) {
                        arr[j] = array[i];
                        j++;
                    }
                }
            } else if (str.equalsIgnoreCase("odd")) {
                int j = 0;
                for (int i = 0; i < array.length; i++) {
                    if (((i + 1) % 2) != 0) {
                        arr[j] = array[i];
                        j++;
                    }
                }
            } else {

                System.out.printf("You have entered an invalid position value!!!%n");
            }
            return arr;

        };

        int[] arr = {2, 3, 5, 1, 3, 2, 5, 1, 3, 2, 15, 1, 1, 3, 15, 1, 3};
        System.out.println(Arrays.toString(pos.charAtPos(arr, "odd")));
    }

}

@FunctionalInterface
interface PositionArr {

    int[] charAtPos(int[] array, String str);
}
