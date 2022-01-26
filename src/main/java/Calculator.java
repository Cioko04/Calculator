import java.util.List;

public class Calculator {

    public String addNumbers(List<String> operands, List<String> operators, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) + Integer.parseInt(operands.get(index)));

    }

    public String subNumbers(List<String> operands, List<String> operators, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) - Integer.parseInt(operands.get(index)));

    }

    public String multiplyNumbers(List<String> operands, List<String> operators, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) * Integer.parseInt(operands.get(index)));

    }

    public String divideNumbers(List<String> operands, List<String> operators, int index) {
        return String.valueOf(Integer.parseInt(operands.get(index - 1)) / Integer.parseInt(operands.get(index)));

    }
}
