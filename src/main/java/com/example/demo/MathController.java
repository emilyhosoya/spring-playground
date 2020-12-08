package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public double getPi() {
        return Math.PI;
    }

    @GetMapping("/calculate")
    public String getCalculation(@RequestParam( defaultValue = "add" ) String operation, @RequestParam int x, @RequestParam int y) {
        String operand = null;
        int result = 0;
        switch (operation) {
            case "add":
                operand = " + ";
                result = x + y;
                break;
            case "subtract":
                operand = " - ";
                result = x - y;
                break;
            case "multiply":
                operand = " * ";
                result = x * y;
                break;
            case "divide":
                operand = " / ";
                result = x / y;
                break;
        }
        return x + operand + y + " = " + result;
    }
    

}