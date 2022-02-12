
import java.util.Scanner;

public class Calculator {
    ErrorHandler errorHandler = new ErrorHandler();

    public String calculate() {
        return new Interpreter().interpret(new Scanner(System.in).nextLine().replace(" ", ""));
    }

    public String addNumbers(double a, double b) {
        return String.valueOf(a + b);
    }

    public String subNumbers(double a, double b) {
        return String.valueOf(a - b);

    }

    public String multiplyNumbers(double a, double b) {
        return String.valueOf(a * b);

    }

    public String divideNumbers(double a, double b) {
        return String.valueOf(a / errorHandler.checkDivider(b));

    }

    public String powerNumbers(double a, double b) {
        return String.valueOf(Math.pow(a, b));
    }

    public String squareNumbers(String number) {
        return String.valueOf(Math.sqrt(errorHandler.checkSqrt(Double.parseDouble(number))));
    }
}
