import java.util.List;

public class Calculator {
    private static Calculator instance;

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    private Calculator() {

    }

    public String calculate(String inputExpression) {
        return Interpreter.getInstance().interpret(inputExpression);
    }

    public String addNumbers(List<String> operands, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) + Integer.parseInt(operands.get(index)));

    }

    public String subNumbers(List<String> operands, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) - Integer.parseInt(operands.get(index)));

    }

    public String multiplyNumbers(List<String> operands, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) * Integer.parseInt(operands.get(index)));

    }

    public String divideNumbers(List<String> operands, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) / Integer.parseInt(operands.get(index)));

    }
}
