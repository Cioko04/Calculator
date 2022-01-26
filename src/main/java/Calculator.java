import java.util.List;

public class Calculator {
    private final Interpreter interpreter;


    public Calculator() {
        interpreter = new Interpreter();
    }

    public String calculate(String inputExpression) {
        List<String> operands = interpreter.getOperands(inputExpression);
        List<String> operators = interpreter.getOperators(inputExpression);
        if (inputExpression.length() > 2) {
            return calculateLowestSequecneOfAction(operands,operators);
        } else {
            return inputExpression;
        }
    }

    private String calculateLowestSequecneOfAction(List<String> operands, List<String> operators) {
        StringBuilder expressionBuild = new StringBuilder();
        operands.set(1, operators.get(1).equals("+") ?
                String.valueOf(Integer.parseInt(operands.get(0)) + Integer.parseInt(operands.get(1)))
                : String.valueOf(Integer.parseInt(operands.get(0)) - Integer.parseInt(operands.get(1))));
        operands.remove(0);
        operators.remove(0);
        operators.remove(0);
        expressionBuild.append(operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            expressionBuild.append(operators.get(i)).append(operands.get(i + 1));
        }
        return calculate(expressionBuild.toString());
    }
}
