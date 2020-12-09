package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MathService {
    private String operation = "add";
    private int x;
    private int y;
    private String operand;
    private int result;
    public String calculateMessage;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void calculate(String operation, int x, int y) {
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
        calculateMessage = x + operand + y + " = " + result;
    }

    private Integer[] n;
    public String sumMessage;

    public Integer[] getArray() {
        return n;
    }

    public void setArray(Integer[] n) {
        this.n = n;
    }

    public void sum(Integer[] n) {
        int sum = 0;
        List<String> numStrings = new ArrayList<>();
        for (int number : n) {
            sum += number;
            numStrings.add(String.valueOf(number));
        }
        sumMessage = String.join(" + ", numStrings) + " = " + sum;
    }

    private String type;
    private String radius;
    private String height;
    private String width;
    private double area;
    public String areaMessage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void area(String type, String radius, String width, String height) {
        if (type.equals("circle")) {
            area = Math.PI * Math.pow(Double.parseDouble(radius), 2);
            areaMessage = "Area of a circle with a radius of " + radius + " is " + area;
        } else if (type.equals("rectangle")) {
            area = Integer.parseInt(width) * Integer.parseInt(height);
            areaMessage = "Area of a " + width + "x" + height + " rectangle is " + area;
        } else {
            areaMessage = "Invalid";
        }
    }
}
