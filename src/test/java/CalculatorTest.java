import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {
    @ParameterizedTest
    @MethodSource("calculateArguments")
    void shouldCalculateCorrectlyParameterizedTest(String expression, String expectedResult) {
        //given
        Calculator calculator = new Calculator();
        //when
        String result = calculator.calculate(expression);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> calculateArguments() {
        return Stream.of(
                arguments("sqrt(9)", "3"),
                arguments("sqrt(9)+sqrt(9)", "6.0"),
                arguments("3^2", "9.00"),
                arguments("3+9.2", "12.2"),
                arguments("10/2", "5.0"),
                arguments("(sqrt(9)+3)*2", "12.00"),
                arguments("(2*(2+2)+2)+2", "12.0")

        );
    }

    @ParameterizedTest
    @MethodSource("addTwoNumbersArguments")
    void shouldAddTwoNumbersCorrectlyParameterizedTest(double a, double b, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.addNumbers(a, b);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> addTwoNumbersArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments(5, 2, String.valueOf(7.0)),
                arguments(20, 5, String.valueOf(25.0)),
                arguments(21, 7, String.valueOf(28.0))
        );
    }

    @ParameterizedTest
    @MethodSource("subtractTwoNumbersArguments")
    void shouldSubtractTwoNumbersCorrectlyParameterizedTest(double a, double b, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.subNumbers(a, b);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> subtractTwoNumbersArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments(5, 2, String.valueOf(3.0)),
                arguments(20, 5, String.valueOf(15.0)),
                arguments(21, 7, String.valueOf(14.0))
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyTwoNumbersArguments")
    void shouldMultiplyTwoNumbersCorrectlyParameterizedTest(double a, double b, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.multiplyNumbers(a, b);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> multiplyTwoNumbersArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments(5, 2, "10.00"),
                arguments(20, 5, "100.00"),
                arguments(2, -2, "-4.00")
        );
    }

    @ParameterizedTest
    @MethodSource("divideTwoNumbersArguments")
    void shouldDivideTwoNumbersCorrectlyParameterizedTest(double a, double b, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.divideNumbers(a, b);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> divideTwoNumbersArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments(6, 2, "3.0"),
                arguments(20, 5, "4.0"),
                arguments(21, 7, "3.0"),
                arguments(10, 3, "3.3")
        );
    }

    @ParameterizedTest
    @MethodSource("powerTwoNumbersArguments")
    void shouldPowerTwoNumbersCorrectlyParameterizedTest(double a, double b, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.powerNumbers(a, b);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> powerTwoNumbersArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments(5, 2, "25.00"),
                arguments(3, 3, "27.000"),
                arguments(2, 4, "16.0000")
        );
    }


    @ParameterizedTest
    @MethodSource("squareNumberArguments")
    void shouldSquareNumberCorrectlyParameterizedTest(String a, String expectedResult) {
        // given
        Calculator calculator = new Calculator();
        // when
        String result = calculator.squareNumber(a);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> squareNumberArguments() {
        return Stream.of(
                //        a,   b,   expectedResult
                arguments("9", "3"),
                arguments("25", "5"),
                arguments("16", "4")
        );

    }
}
