import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorHandler extends Exception{
   private static final Aggregator agregater = new Aggregator();

    public double checkNumber(String numberToCheck) {
        double number;
        try {
            number = Double.parseDouble(numberToCheck);
        } catch (IllegalArgumentException exception) {
            try {
                number = Double.parseDouble(agregater.getUserAssignation().get(numberToCheck));
            } catch (NullPointerException pointerException) {
                System.out.println("There is no number assigned to this variable!\n" +
                        "Please enter value: ");
                number = getNumber();
            }
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
                number = getNumber();
            }
        } while (continueLoop);
        return number;
    }

    public double checkSqrt(double number) {
        boolean continueLoop = true;
        do {
            try {
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                continueLoop = false;
            } catch (IllegalArgumentException exception) {
                System.out.println("Square root cannot be obtained from negative number!\n" +
                        "Pleas enter new value: ");
                number = getNumber();
            }
        } while (continueLoop);
        return number;
    }

    private double getNumber() {
        double number = 0;
        boolean continueLoop = true;
        do {
            try {
                number = new Scanner(System.in).nextDouble();
                continueLoop = false;
            } catch (InputMismatchException mismatchException) {
                System.out.println("Please enter the number!");
            }
        } while (continueLoop);
        return number;
    }
    public boolean checkExpression(String inputExpression){
        Pattern pattern = Pattern.compile("[^a-z0-9()+/*=-]");
        Matcher matcher = pattern.matcher(inputExpression);
        if (matcher.find()) {
            System.out.println("Given expression doesn't match!\n" +
                    "Please correct it!");
        }
        return matcher.find();
    }
}
