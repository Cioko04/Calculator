import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        System.out.println(calculator.calculate("2^((2+2)(3+(2*2))+(4/2)-27)"));
//        System.out.println(calculator.calculate("-(2+2)(2-4)"));
//        System.out.println(calculator.calculate("4-7+2*27-sqrt(9)"));
//        System.out.println(calculator.calculate("sqrt(9)+2"));
//        System.out.println(calculator.calculate("sqrt(-2*(-2))"));
//        Agregater agregater = new Agregater();
//        agregater.inputExpression("a: sqrt(-2*(-2))");
//        agregater.inputExpression("b : sqrt(9)+2");
//        Map<String, String> x = agregater.getUserInput();
//        System.out.println(calculator.calculate(x.get("a") + "+" + x.get("b")));
        System.out.println(calculator.calculate());
//        String inputExpression = "1+3+a";
//        List<String> operands = new ArrayList<>(List.of(inputExpression.split("[+/*^-]")));
//        for (int i = 0; i < operands.size(); i++) {
//            if (operands.get(i).isEmpty()) {
//                operands.remove(i);
//                operands.set(i, "-" + operands.get(i));
//            }
//        }
//        Map<String,String> k = new HashMap<>();
//        k.put("a","3");
//
//        operands.forEach(x -> System.out.print(x + " "));
    }

}
