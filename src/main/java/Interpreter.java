import java.util.ArrayList;
import java.util.List;

public class Interpreter {
    private final Calculator calculator;

    public Interpreter() {
        calculator = new Calculator();
    }

    public String interpret(String inputExpression) {
        List<String> operands = getOperands(inputExpression);
        List<String> operators = getOperators(inputExpression);
        int index = 0;
        if (operands.size() > 1) {
            if (operators.contains("/") && operators.contains("*")) {
                index = Math.min(operators.indexOf("*"), operators.indexOf("/"));
            } else if (operators.contains("/")) {
                index = operators.indexOf("/");
            } else if (operators.contains("*")) {
                index = operators.indexOf("*");
            } else if (operators.contains("+") && operators.contains("-")) {
                index = Math.min(operators.indexOf("+"), operators.indexOf("-"));
            } else if (operators.contains("+")) {
                index = operators.indexOf("+");
            } else if (operators.contains("-")) {
                index = operators.indexOf("-");
            }
            return interpret(choseAction(operands, operators, index));
        } else return inputExpression;

    }

    private String choseAction(List<String> operands, List<String> operators, int index) {
        String replacmentExpression = "";
        switch (operators.get(index)) {
            case "*":
                replacmentExpression = calculator.multiplyNumbers(operands, operators, index);
                break;
            case "/":
                replacmentExpression = calculator.divideNumbers(operands, operators, index);
                break;
            case "+":
                replacmentExpression = calculator.addNumbers(operands, operators, index);
                break;
            case "-":
                replacmentExpression = calculator.subNumbers(operands, operators, index);
                break;
        }
        return modifyExpression(operands, operators, index, replacmentExpression);
    }

    private String modifyExpression(List<String> operands, List<String> operators, int index, String replacmentExpression) {
        operands.set(index, replacmentExpression);
        operands.remove(index - 1);
        operators.remove(index);
        operators.remove(0);
        return updateExpression(operands,operators);
    }

    private String updateExpression(List<String> operands, List<String> operators) {
        StringBuilder expressionBuild = new StringBuilder();
        expressionBuild.append(operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            expressionBuild.append(operators.get(i)).append(operands.get(i + 1));
        }
        return expressionBuild.toString();
    }


    public List<String> getOperands(String inputExpression) {
        return checkFirstValue(inputExpression);
    }

    public List<String> getOperators(String inputExpression) {
        return new ArrayList<>(List.of(inputExpression.split("[0-9]+")));
    }

    private List<String> checkFirstValue(String inputExpression) {
        List<String> operands = new ArrayList<>(List.of(inputExpression.split("[+/*-]")));
        if (operands.get(0).equals("")) {
            operands.remove(0);
            operands.set(0, "-" + operands.get(0));
        }
        return operands;
    }
}