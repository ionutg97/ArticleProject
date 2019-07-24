package training.endava.app.division;

public class DivisionUtil {

    public Double divideWithException(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("b cannot be 0");
        }
        return a / b;
    }

    public Double divideWithNan(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return a / b;
    }
}
