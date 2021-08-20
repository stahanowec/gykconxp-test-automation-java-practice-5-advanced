package com.epam.test.automation.java.practice5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayRectangles {

    private List<Rectangle> rectangleArray;

    public ArrayRectangles(int n) {
        this.rectangleArray = new ArrayList<>(n);
    }

    public boolean addRectangle(Rectangle rectangle) {
        return rectangleArray.add(rectangle);
    }

    public int numberMaxArea() {

        return IntStream.range(0, rectangleArray.size())
                .mapToObj(i -> {
                            var value = rectangleArray.get(i).area();
                            return new Pair(i, value);
                        }
                ).max(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);

    }

    public int numberMinPerimeter() {
        return IntStream.range(0, rectangleArray.size())
                .mapToObj(i -> {
                            var value = rectangleArray.get(i).perimeter();
                            return new Pair(i, value);
                        }
                ).min(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int numberSquares() {
        return (int) rectangleArray.stream().filter(Rectangle::isSquare).count();
    }


    public static class Pair {
        private int num;
        private double value;

        public Pair(int num, double value) {
            this.num = num;
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public double getValue() {
            return value;
        }
    }

}
