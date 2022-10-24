package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class VowelFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new VowelFunction().run();
    }

    private void run() {
        String msg = "What's the time?";

        isVowel vow = str -> {
            StringBuilder sb = new StringBuilder();
            String sb1 = "";
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            loop:
            for (int i = 0; i < str.toLowerCase().length(); i++) {
                for (int j = 0; j < vowels.length; j++) {
                    if (str.charAt(i) == vowels[j]) {
                        sb.append(str.charAt(i));
                        continue loop;
                    }
                }
                sb1 += str.charAt(i);

            }
            return sb.toString() + sb1;
        };

        System.out.println(vow.stringVowels(msg));
    }

}

@FunctionalInterface
interface isVowel {

    String stringVowels(String str);
}
