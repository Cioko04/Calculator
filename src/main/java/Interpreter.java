import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Interpreter {
    private final Calculator calculator = new Calculator();

    public String interpret(String inputExpression) {
        List<String> operands = getOperands(inputExpression);
        List<String> operators = getOperators(inputExpression);
        if (operands.size() > 1) {
            return interpret(chooseAction(operands, operators, getIndexOfOperator(operators)));
        } else return inputExpression;

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

    private String chooseAction(List<String> operands, List<String> operators, int index) {
        String replacementExpression = switch (operators.get(index)) {
            case "*" -> calculator.multiplyNumbers(operands, index);
            case "/" -> calculator.divideNumbers(operands, index);
            case "+" -> calculator.addNumbers(operands, index);
            case "-" -> calculator.subNumbers(operands, index);
            default -> "";
        };
        return modifyExpression(operands, operators, index, replacementExpression);
    }

    private String modifyExpression(List<String> operands, List<String> operators, int index, String replacementExpression) {
        operands.set(index, replacementExpression);
        operands.remove(index - 1);
        operators.remove(index);
        operators.remove(0);
        return updateExpression(operands, operators);
    }

    private String updateExpression(List<String> operands, List<String> operators) {
        StringBuilder expressionBuild = new StringBuilder();
        expressionBuild.append(operands.get(0));
        Stream.iterate(0, n -> n + 1)
                .limit(operators.size())
                .forEach(x -> expressionBuild.append(operators.get(x)).append(operands.get(x + 1)));
        return expressionBuild.toString();
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
        return new ArrayList<>(List.of(inputExpression.split("[0-9]+")));
    }

}