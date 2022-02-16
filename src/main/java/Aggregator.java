import java.util.HashMap;
import java.util.Map;

public class Aggregator {
    private static final Map<String, String> userAssignation = new HashMap<>();
    private static final Interpreter interpreter = new Interpreter();

    public void inputExpression(String inputExpression) {
        String[] splitInput = inputExpression.replace(" ", "").split("=");
        userAssignation.put(splitInput[0], interpreter.interpret(splitInput[1]));
    }

    public Map<String, String> getUserAssignation() {
        return userAssignation;
    }

}
