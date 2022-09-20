package za.co.mecer;

import za.co.mecer.formula.FormulaUtility;

/**
 *
 * @author Dimakatso Sebatane
 */
public class MathematicalFormula {

    public static void main(String[] args) {
        new MathematicalFormula().run();
    }

    private void run() {
        double ans = FormulaUtility.formula_3x(5);
        System.out.printf("3x ans is : %.2f%n", ans);

        ans = FormulaUtility.formula_3xPlusY(5, 100);
        System.out.printf("3x + y ans is : %.2f%n", ans);

        ans = FormulaUtility.formula_xPlusYDivZ(5, 100, 2);
        System.out.printf("(x + y)/z ans is : %.2f%n", ans);

        ans = FormulaUtility.formula_3xPlusYDivZPlusV(5, 100, 2, 2);
        System.out.printf("(3x + y)/(z+2) ans is : %.2f%n", ans);

    }

}
