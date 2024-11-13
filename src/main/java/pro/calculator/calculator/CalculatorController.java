package pro.calculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/calculator/plus?num1=5&num2=5")
    public String plus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: параметры num1 и num2 должны быть заданы";
        }
        int result = CalculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/calculator/minus?num1=5&num2=5")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: параметры num1 и num2 должны быть заданы";
        }
        int result = CalculatorService.minus(num1, num2);
        return String.format("%d − %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/calculator/multiply?num1=5&num2=5")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: параметры num1 и num2 должны быть заданы";
        }
        int result = CalculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/calculator/divide?num1=5&num2=5")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: параметры num1 и num2 должны быть заданы";
        }
        try {
            double result = CalculatorService.divide(num1, num2);
            return String.format("%d / %d = %.2f", num1, num2, result);
        } catch (ArithmeticException e) {
            return "Ошибка: деление на ноль невозможно";
        }
    }
}