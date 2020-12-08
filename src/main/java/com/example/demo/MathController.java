package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

//    @RequestMapping(method=RequestMethod.GET)

    @GetMapping("/pi")
    public double getPi() {
        return Math.PI;
    }

}