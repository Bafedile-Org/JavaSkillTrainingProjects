
/**
 *
 * @author Dimakatso Bafedile Sebatane
 */
public class RomanNumerals {

    public static void main(String[] args) {
        new RomanNumerals().run();
    }

    private void run() {
        new RomanCount().getRoman();
    }
}

class RomanCount {

    public void getRoman() {
        int toRoman;
        for (int count = 1; count <= 110; count++) {
            toRoman = count;
            System.out.printf("%d :", toRoman);
            toRoman = makeRoman(toRoman, 100, 'C');
            if (toRoman == 90) {
                System.out.print("XC");
                toRoman -= 90;
            }
            toRoman = makeRoman(toRoman, 50, 'L');
            if (toRoman == 40) {
                System.out.print("XL");
                toRoman -= 40;
            }
            toRoman = makeRoman(toRoman, 10, 'X');
            if (toRoman == 9) {
                System.out.print("IX");
                toRoman -= 9;
            }

            toRoman = makeRoman(toRoman, 5, 'V');
            if (toRoman == 4) {
                System.out.print("IV");
                toRoman -= 4;
            }
            toRoman = makeRoman(toRoman, 1, 'I');
            System.out.println();

        }
    }

    int makeRoman(int in, int decrement, char ch) {

        while (in >= decrement) {
            System.out.print(ch);
            in -= decrement;
        }
        return in;
    }

}
