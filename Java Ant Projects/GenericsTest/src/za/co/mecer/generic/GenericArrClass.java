package za.co.mecer.generic;

/**
 *
 * @author Dimakatso Sebatane
 */
public class GenericArrClass<T> {

    private T[] arr = null;

    public GenericArrClass(T[] arr) {
        this.arr = arr;
    }

    public GenericArrClass() {

    }

    public void displayArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public <T> void displayArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public <T> T[] getArray(T[] arr) {
        return arr;
    }
}
