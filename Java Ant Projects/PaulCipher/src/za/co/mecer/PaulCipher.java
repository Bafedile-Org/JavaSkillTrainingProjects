package za.co.mecer;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaulCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PaulCipher().run();

    }

    private void run() {
        String string = "MATT";
        char[] alphas = new char[26];
        Alphabets al = array -> {
            int i = 0;
            for (char value = 'A'; value <= 'Z'; value++) {
                array[i] = value;
                i++;
            }
        };
        al.getAlphabets(alphas);
        Cipher cipher = str -> cipher(str, alphas);
        System.out.println(cipher.cipherText(string));
    }

    private String cipher(String str, char[] alphas) {
        StringBuilder sb = new StringBuilder();
        str = str.toUpperCase();
        loop:
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                sb.append(c);
            } else {
                if (!Character.isLetter(c)) {
                    sb.append(c);
                }

                for (int j = 0; j < alphas.length; j++) {
                    if (c == alphas[j]) {
                        for (int k = 1; k <= str.indexOf(c); k++) {
                            if (Character.isLetter(str.charAt(i - k))) {
                                sb.append(alphas[(((int) str.charAt(i - k)) - 64 + (j)) % 26]);
                                continue loop;
                            }
                        }

                    }
                }
            }
        }
        return sb.toString();
    }
}

@FunctionalInterface
interface Cipher {

    String cipherText(String str);
}

@FunctionalInterface
interface Alphabets {

    void getAlphabets(char[] array);
}
