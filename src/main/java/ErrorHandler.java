import java.util.Scanner;

public class ErrorHandler {
    Agregater agregater = Agregater.getInstance();

    public double tryNumber(String numberToTry) {
        double number;
        try {
            number = Double.parseDouble(numberToTry);
        } catch (IllegalArgumentException exception) {
            number = Double.parseDouble(agregater.getUserInput().get(numberToTry));
        }
        return number;
    }

    public double checkDivider(double number) {
        boolean continueLoop = true;
        do {
            try {
                if (number == 0) {
                    throw new ArithmeticException();
                }
                continueLoop = false;
            } catch (ArithmeticException exception) {
                System.out.println("Does not divide by 0!\n" +
                        "Please enter new value: ");
                number = new Scanner(System.in).nextDouble();
            }
        } while (continueLoop);
        return number;
    }
    public double checkSqrt(double number){
        boolean continueLoop = true;
        do {
            try {
                if (number < 0){
                    throw new IllegalArgumentException();
                }
                continueLoop = false;
            }catch (IllegalArgumentException exception){
                System.out.println("Square root cannot be obtained from negative number!\n" +
                        "Pleas enter new value: ");
                number = new Scanner(System.in).nextDouble();
            }
        }while (continueLoop);
        return number;
    }
}
