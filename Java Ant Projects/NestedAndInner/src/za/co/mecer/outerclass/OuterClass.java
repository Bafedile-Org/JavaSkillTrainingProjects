package za.co.mecer.outerclass;

/**
 *
 * @author Dimakatso Sebatane
 */
public class OuterClass {

    private InnerClass innerClassRef;
    private int value;

    public OuterClass(int value) {
        this.setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public class InnerClass {

        private int innerValue;

        public InnerClass(int innerValue) {
            this.setInnerValue(innerValue);
        }

        public void setInnerValue(int innerValue) {
            this.innerValue = innerValue;
        }

        public int getInnerValue() {
            return innerValue;
        }

        public int calcAllValues() {
            return innerValue * value;
        }

        @Override
        public String toString() {
            return String.format("Inner Value: %d%n"
                    + "Inner Calc Values: %d%n%n", innerValue, calcAllValues());
        }
    }

    public void setInnerClassRef() {
        this.innerClassRef = new InnerClass(3);
    }

    public InnerClass getInnerClassRef() {
        return innerClassRef;
    }

    @Override
    public String toString() {
        return String.format("Outer Value: %d%n%n", value);
    }

    public static class InnerStatic {

        private String str;

        public InnerStatic(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

    }

    public void calculate(int x, int y) {
        int z = x * y;

        class Multiply {

            int multiiply() {
                return z * (x % y) + x;
            }
        }

        System.out.printf("Fancy Multiplication: %d%n", new Multiply().multiiply());
    }

}
