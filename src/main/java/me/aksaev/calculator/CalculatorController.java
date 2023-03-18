package me.aksaev.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plusCalculator(@RequestParam(value = "num1", required = false) Integer num1,
                                 @RequestParam(value = "num2", required = false) Integer num2) {
        return buildView(num1, num2, "+");
    }

    @GetMapping("/minus")
    public String minusCalculator(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2) {
        return buildView(num1, num2, "-");
    }

    @GetMapping("/multiply")
    public String multiplyCalculator(@RequestParam(value = "num1", required = false) Integer num1,
                                     @RequestParam(value = "num2", required = false) Integer num2) {
        return buildView(num1, num2, "*");
    }

    @GetMapping("/divide")
    public String divideCalculator(@RequestParam(value = "num1", required = false) Integer num1,
                                   @RequestParam(value = "num2", required = false) Integer num2) {
        return buildView(num1, num2, "/");
    }

    private String buildView(Integer num1, Integer num2, String operation) {
        if (num1 == null || num2 == null) {
            return "<b>Введите корректно num1 и num2</b>";
        }
        if ("/".equals(operation) && num2 == 0) {
            return "<b>Делить на \"0\" нельзя!</b>";
        }
        Number result;
        switch (operation) {
            case "-":
                result = calculatorService.minus(num1, num2);
                break;
            case "*":
                result = calculatorService.multiply(num1, num2);
                break;
            case "/":
                result = calculatorService.divide(num1, num2);
                break;
            default:
                result = calculatorService.plus(num1, num2);
        }
        return num1 + " " + operation + " " + num2 + " = " + result;
    }

}
