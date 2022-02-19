import java.util.HashMap;
import java.util.Map;

public class Aggregator {
    private static final Map<String, String> USER_ASSIGNATION = new HashMap<>();
    private static final Interpreter INTERPRETER = new Interpreter();

    public void addInputExpression(String inputExpression) {
        String[] splitInput = inputExpression.split("=");
        USER_ASSIGNATION.put(splitInput[0], INTERPRETER.interpret(splitInput[1]));
    }

    public Map<String, String> getUserAssignation() {
        return USER_ASSIGNATION;
    }

}
