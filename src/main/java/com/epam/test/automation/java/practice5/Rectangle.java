package com.epam.test.automation.java.practice5;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) throw new IllegalArgumentException();
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double a) {
        this(a, 5);
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return getSideA() * getSideB();
    }

    public double perimeter() {
        return (2 * getSideA()) + (2 * getSideB());
    }

    public boolean isSquare() {
        return getSideA() == getSideB();
    }

    public void replaceSides() {
        var temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

}
