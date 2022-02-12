import java.util.HashMap;
import java.util.Map;

public class Agregater {
    private final Map<String, String> userInput = new HashMap<>();
    private static Agregater instance;

    public static Agregater getInstance() {
        if (instance == null) {
            instance = new Agregater();
        }
        return instance;
    }
    private Agregater(){

    }

    public void inputExpression(String inputExpression) {
        Interpreter interpreter = new Interpreter();
        String[] splitInput = inputExpression.replace(" ", "").split("=");
        userInput.put(splitInput[0], interpreter.interpret(splitInput[1]));
    }

    public Map<String, String> getUserInput() {
        return userInput;
    }

}
