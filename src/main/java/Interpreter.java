import java.util.ArrayList;
import java.util.List;

public class Interpreter {
    private final Calculator calculator = new Calculator();

    public String interpret(String inputExpression) {
        List<String> operands = getOperands(inputExpression);
        List<String> operators = getOperators(inputExpression);
        if (operands.size() > 1) {
            return interpret(updateExpression(operands, operators, getIndexOfOperator(operators), inputExpression));
        } else return inputExpression;

    }

    private String updateExpression(List<String> operands, List<String> operators, int index, String inputExpression) {
        String expressionToReplace = getExpressionToReplace(operands, operators, index);
        String replacementExpression = getReplacementExpression(operands, operators, index);
        return inputExpression.replace(expressionToReplace, replacementExpression);

    }

    private int getIndexOfOperator(List<String> operators) {
        int index = 0;
        if (operators.contains("/")) {
            index = operators.indexOf("/");
        } else if (operators.contains("*")) {
            index = operators.indexOf("*");
        } else if (operators.contains("+") && operators.contains("-") && operators.indexOf("-") != 0) {
            index = Math.min(operators.indexOf("+"), operators.indexOf("-"));
        } else if (operators.contains("+")) {
            index = operators.indexOf("+");
        } else if (operators.contains("-")) {
            index = operators.indexOf("-") > 0 ? operators.indexOf("-") : 1;
        }
        return index;
    }

    private String getReplacementExpression(List<String> operands, List<String> operators, int index) {
        return switch (operators.get(index)) {
            case "*" -> calculator.multiplyNumbers(operands, index);
            case "/" -> calculator.divideNumbers(operands, index);
            case "+" -> calculator.addNumbers(operands, index);
            case "-" -> calculator.subNumbers(operands, index);
            default -> "";
        };
    }

    private String getExpressionToReplace(List<String> operands, List<String> operators, int index) {
        return operands.get(index - 1) + operators.get(index) + operands.get(index);
    }

    public List<String> getOperands(String inputExpression) {
        List<String> operands = new ArrayList<>(List.of(inputExpression.split("[+/*-]")));
        if (operands.get(0).equals("")) {
            operands.remove(0);
            operands.set(0, "-" + operands.get(0));
        }
        return operands;
    }

    public List<String> getOperators(String inputExpression) {
        return new ArrayList<>(List.of(inputExpression.split("[0-9]+[.]*[0-9]*")));
    }

}