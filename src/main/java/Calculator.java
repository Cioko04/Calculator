import java.util.List;

public class Calculator {

    public String calculate(String inputExpression) {
        return new Interpreter().interpret(inputExpression);
    }

    public String addNumbers(List<String> operands, int index) {
        return String.valueOf(Double.parseDouble(operands.get(index - 1)) + Double.parseDouble(operands.get(index)));

    }

    public String subNumbers(List<String> operands, int index) {
        return String.valueOf(Double.parseDouble(operands.get(index - 1)) - Double.parseDouble(operands.get(index)));

    }

    public String multiplyNumbers(List<String> operands, int index) {
        return String.valueOf(Double.parseDouble(operands.get(index - 1)) * Double.parseDouble(operands.get(index)));

    }

    public String divideNumbers(List<String> operands, int index) {
        return String.valueOf(Double.parseDouble(operands.get(index - 1)) / Double.parseDouble(operands.get(index)));

    }
}
