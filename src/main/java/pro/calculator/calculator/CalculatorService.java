package pro.calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static double divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль нельзя");
        }
        return (double) num1 / num2;
    }
}