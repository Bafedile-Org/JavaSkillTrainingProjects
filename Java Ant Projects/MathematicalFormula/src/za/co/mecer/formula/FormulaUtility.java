package za.co.mecer.formula;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FormulaUtility {

    public static double formula_3x(final double x) {
        return 3 * x;
    }

    public static double formula_3xPlusY(final double x, final double y) {
        return formula_3x(x) + y;
    }

    public static double formula_xPlusYDivZ(final double x, double y, final double z) {
        return (x + y) / z;
    }

    public static double formula_3xPlusYDivZPlusV(final double x, final double y, final double z, double v) {
        return formula_3xPlusY(x, y) / (z + v);
    }
}
