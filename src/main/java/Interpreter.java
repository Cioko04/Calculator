import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Interpreter {
    private static final Calculator CALCULATOR = new Calculator();
    private static final Aggregator AGGREGATOR = new Aggregator();
    private static final ErrorHandler ERROR_HANDLER = new ErrorHandler();
    private String expressionToReplace;
    private String replacementExpression;

    public String interpret(String inputExpression) {
        if (!inputExpression.contains("=")) {
            if (inputExpression.contains("(")) {
                return interpret(doExpressionWithBracket(inputExpression));
            } else if (getNumberToSquare(inputExpression) != null) {
                return interpret(doExpressionWithSqrt(inputExpression));
            } else {
                List<String> operands = getOperands(inputExpression);
                if (operands.size() > 1) {
                    return interpret(doSimpleExpression(inputExpression, operands));
                } else if (!Pattern.compile("[a-z]").matcher(inputExpression).find()) {
                    return inputExpression;
                } else {
                    return String.valueOf(ERROR_HANDLER.checkNumber(inputExpression));
                }
            }
        } else if (Pattern.compile("[a-z]").matcher(inputExpression).find()) {
            AGGREGATOR.addInputExpression(inputExpression);
            return CALCULATOR.calculate();
        } else return "This isn't right value!";


    }

    private String doExpressionWithBracket(String inputExpression) {
        inputExpression = addMultiplySign(inputExpression);
        expressionToReplace = "(" + getExpressionInBracket(inputExpression) + ")";
        replacementExpression = interpret(getExpressionInBracket(inputExpression));
        return updateExpression(expressionToReplace, replacementExpression, inputExpression);
    }

    private String getExpressionInBracket(String inputExpression) {
        return inputExpression.substring(
                inputExpression.lastIndexOf("(") + 1
                , inputExpression.indexOf(")", inputExpression.lastIndexOf("(")));
    }

    private String doExpressionWithSqrt(String inputExpression) {
        expressionToReplace = "sqrt" + getNumberToSquare(inputExpression);
        replacementExpression = CALCULATOR.squareNumbers(getNumberToSquare(inputExpression));
        return updateExpression(expressionToReplace, replacementExpression, inputExpression);
    }

    private String doSimpleExpression(String inputExpression, List<String> operands) {
        List<String> operators = getOperators(inputExpression);
        expressionToReplace = getExpressionToReplace(operands, operators, getIndexOfOperator(operators));
        replacementExpression = getReplacementExpression(operands, operators, getIndexOfOperator(operators));
        return updateExpression(expressionToReplace, replacementExpression, inputExpression);
    }

    private String getNumberToSquare(String inputExpression) {
        Pattern pattern = Pattern.compile("sqrt\\d*.\\d*");
        Matcher matcher = pattern.matcher(inputExpression);
        return matcher.find() ?
                inputExpression.substring(matcher.start(), matcher.end()).replace("sqrt", "")
                : null;
    }

    private String addMultiplySign(String inputExpression) {
        inputExpression = inputExpression.replace(")(", ")*(");
        inputExpression = inputExpression.replace("0(", "0*(");
        inputExpression = inputExpression.replace("1(", "1*(");
        inputExpression = inputExpression.replace("2(", "2*(");
        inputExpression = inputExpression.replace("3(", "3*(");
        inputExpression = inputExpression.replace("4(", "4*(");
        inputExpression = inputExpression.replace("5(", "5*(");
        inputExpression = inputExpression.replace("6(", "6*(");
        inputExpression = inputExpression.replace("7(", "7*(");
        inputExpression = inputExpression.replace("8(", "8*(");
        inputExpression = inputExpression.replace("9(", "9*(");
        return inputExpression;
    }

    private String updateExpression(String expressionToReplace, String replacementExpression, String inputExpression) {
        return inputExpression.replace(expressionToReplace, replacementExpression);
    }

    private int getIndexOfOperator(List<String> operators) {
        int index = 0;
        if (operators.contains("^")) {
            index = operators.indexOf("^");
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
        return index;
    }

    private String getReplacementExpression(List<String> operands, List<String> operators, int index) {
        double a = ERROR_HANDLER.checkNumber(operands.get(index - 1));
        double b = ERROR_HANDLER.checkNumber(operands.get(index));
        return switch (operators.get(index)) {
            case "^" -> CALCULATOR.powerNumbers(a, b);
            case "*" -> CALCULATOR.multiplyNumbers(a, b);
            case "/" -> CALCULATOR.divideNumbers(a, b);
            case "+" -> CALCULATOR.addNumbers(a, b);
            case "-" -> CALCULATOR.subNumbers(a, b);
            default -> "";
        };
    }

    private String getExpressionToReplace(List<String> operands, List<String> operators, int index) {
        return operands.get(index - 1) + operators.get(index) + operands.get(index);
    }

    private List<String> getOperands(String inputExpression) {
        List<String> operands = new ArrayList<>(List.of(inputExpression.split("[+/*^-]")));
        for (int i = 0; i < operands.size(); i++) {
            if (operands.get(i).isEmpty()) {
                operands.remove(i);
                operands.set(i, "-" + operands.get(i));
            }
        }
        return operands;


    }

    private List<String> getOperators(String inputExpression) {

        List<String> operators = new ArrayList<>(List.of(inputExpression.split("[\\d\\.w\\w]")));
        operators.set(0, "");
        operators = new ArrayList<>(
                List.of(operators.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining())
                        .split("")
                )
        );
        operators.add(0, "");
        return operators;
    }

}