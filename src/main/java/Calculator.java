import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    private static final ErrorHandler ERROR_HANDLER = new ErrorHandler();


    public String calculate() {
            return ERROR_HANDLER.getExpression();

    }

    public String addNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)));
    }

    public String subNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b)));
    }

    public String multiplyNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)));
    }

    public String divideNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).divide(BigDecimal.valueOf(ERROR_HANDLER.checkDivider(b)), RoundingMode.HALF_DOWN));
    }

    public String powerNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).pow((int) b));
    }

    public String squareNumbers(String number) {
        return String.valueOf(BigDecimal.valueOf(ERROR_HANDLER.checkSqrt(Double.parseDouble(number))).sqrt(MathContext.UNLIMITED));
    }
}
