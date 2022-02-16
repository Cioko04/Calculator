import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {
    private static final ErrorHandler errorHandler = new ErrorHandler();
    private static final Interpreter interpreter = new Interpreter();


    public String calculate() {
        String inputExpression;
        do {
            inputExpression = new Scanner(System.in).nextLine().replace(" ", "");
        } while (errorHandler.checkExpression(inputExpression));
        return interpreter.interpret(inputExpression);
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
        return String.valueOf(BigDecimal.valueOf(a).divide(BigDecimal.valueOf(errorHandler.checkDivider(b)), RoundingMode.HALF_DOWN));
    }

    public String powerNumbers(double a, double b) {
        return String.valueOf(BigDecimal.valueOf(a).pow((int) b));
    }

    public String squareNumbers(String number) {
        return String.valueOf(BigDecimal.valueOf(errorHandler.checkSqrt(Double.parseDouble(number))).sqrt(MathContext.UNLIMITED));
    }
}
