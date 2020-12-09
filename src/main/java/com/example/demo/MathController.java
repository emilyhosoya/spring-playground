package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public double getPi() {
        return Math.PI;
    }

    @GetMapping("/calculate")
    public String getCalculation(MathService mathService) {
        mathService.calculate(mathService.getOperation(), mathService.getX(), mathService.getY());
        return mathService.calculateMessage;
    }

    @PostMapping("/sum")
    public String postSum(MathService mathService) {
        mathService.sum(mathService.getArray());
        return mathService.sumMessage;
//        int sum = 0;
//        List<String> numStrings = new ArrayList<>();
//        for (int number : n) {
//            sum += number;
//            numStrings.add(String.valueOf(number));
//        }
//        return String.join(" + ", numStrings) + " = " + sum;
    }

    @PostMapping("/volume/{l}/{w}/{h}")
    public String postVolume(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        int volume = l * w * h;
        return String.format("The volume of a %dx%dx%d rectangle is " + volume, l, w, h);
    }

    @PatchMapping("/volume/{l}/{w}/{h}")
    public String patchVolume(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        int volume = l * w * h;
        return String.format("The volume of a %dx%dx%d rectangle is " + volume, l, w, h);
    }

    @PostMapping(value = "/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postArea(@RequestBody MathService mathService) {
        mathService.area(mathService.getType(), mathService.getRadius(), mathService.getWidth(), mathService.getHeight());
        return mathService.areaMessage;
    }

    //    @RequestMapping(method=RequestMethod.GET)


}