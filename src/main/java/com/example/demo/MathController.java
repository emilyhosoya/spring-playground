package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
                result = Math.addExact(x,y);
                break;
            case "subtract":
                operand = " - ";
                result = Math.subtractExact(x,y);
                break;
            case "multiply":
                operand = " * ";
                result = Math.multiplyExact(x,y);
                break;
            case "divide":
                operand = " / ";
                result = Math.floorDiv(x,y);
                break;
        }
        return x + operand + y + " = " + result;
    }

    @PostMapping("/sum")
    public String addNumbers(@RequestParam Integer[] n) {
        int sum = 0;
        List<String> numStrings = new ArrayList<>();
        for (int number : n) {
            sum += number;
            numStrings.add(String.valueOf(number));
        }
        return String.join(" + ", numStrings) + " = " + sum;
    }


}