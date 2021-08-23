package com.epam.test.automation.java.practice5;

public class Rectangle {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a) {
        this.a = a;
        this.b = 5;
    }

    public Rectangle() {
        this.a = 4;
        this.b = 3;
    }


    public double getSideA() {
        return Math.abs(a);
    }

    public double getSideB() {
        return Math.abs(b);
    }


    public double area() {
        return Math.abs(a * b);
    }


    public double perimeter() {
        return Math.abs((2 * a) + Math.abs(2 * b));
    }


    public boolean isSquare() {
        return Math.abs(a) == Math.abs(b);
    }


    public void replaceSides() {
        var temp = Math.abs(this.a);
        this.a = Math.abs(this.b);
        this.b = temp;
    }

}
