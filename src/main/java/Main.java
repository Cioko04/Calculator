import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(new Scanner(System.in).nextLine().replace(" ", "")));
    }

}
