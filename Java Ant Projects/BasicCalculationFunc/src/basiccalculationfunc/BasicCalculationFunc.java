package basiccalculationfunc;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BasicCalculationFunc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BasicCalculationFunc().run();
    }

    private void run() {
        Mathematics cal = (num1, operator, num2) -> {
            calculate(num1, operator, num2);
        };

        int value1 = 23, value2 = 0;
        char operator = '/';
        cal.basicCalculator(value1, operator, value2);

    }

    private void calculate(int num1, char operator, int num2) {
        StringBuilder sb = new StringBuilder();
        try {
            switch (operator) {
                case '+':
                    sb.append(String.format("Sum of %d and %d is %d%n", num1, num2, (num1 + num2)));
                    break;
                case '-':
                    sb.append(String.format("Difference of %d and %d is %d%n", num1, num2, (num1 - num2)));
                    break;
                case '/':
                    sb.append(String.format("Quotient of %d and %d is %d%n", num1, num2, (num1 / num2)));
                    break;
                case '*':
                    sb.append(String.format("Product of %d and %d is %d%n", num1, num2, (num1 * num2)));
                    break;
                case '%':
                    sb.append(String.format("Modulus of %d and %d is %d%n", num1, num2, (num1 % num2)));
                    break;
                default:
                    sb.append("Null, invalid operator!");

            }

            System.out.println(sb);
        } catch (ArithmeticException ex) {
            System.out.printf("ERROR: %s%n", ex.getMessage());
        }

    }

    @FunctionalInterface
    interface Mathematics {

        void basicCalculator(int num1, char operator, int num2);
    }
}
