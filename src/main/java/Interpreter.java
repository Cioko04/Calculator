import java.util.ArrayList;
import java.util.List;

public class Interpreter {


    public List<String> getOperands(String inputExpression) {
        return checkFirstValue(inputExpression);
    }

    public List<String> getOperators(String inputExpression) {
        return new ArrayList<>(List.of(inputExpression.split("[0-9]+")));
    }

    private List<String> checkFirstValue(String inputExpression) {
        List<String> operands = new ArrayList<>(List.of(inputExpression.split("[+-]")));
        if (getOperators(inputExpression).get(0).equals("-")){
            operands.remove(0);
            operands.set(0, "-" + operands.get(0));
        }
        return operands;
    }
}