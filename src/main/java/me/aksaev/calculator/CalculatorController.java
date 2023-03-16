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

    @GetMapping()
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plusCalculator(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>Введите корректно num1 и num2</b>";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/minus")
    public String minusCalculator(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>Введите корректно num1 и num2</b>";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/multiply")
    public String multiplyCalculator(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>Введите корректно num1 и num2</b>";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/divide")
    public String divideCalculator(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "<b>Введите корректно num1 и num2</b>";
        }
        if (num2.equals("0")) {
            return "<b>Делить на \"0\" нельзя!</b>";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(Integer.parseInt(num1), Integer.parseInt(num2));
    }

}
