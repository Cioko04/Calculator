public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("2^((2+2)(3+(2*2))+(4/2)-27)"));
        System.out.println(calculator.calculate("-(2+2)(2-4)"));
        System.out.println(calculator.calculate("4-7+2*27-sqrt(9)"));
        System.out.println(calculator.calculate("sqrt(9)+2"));
    }

}
