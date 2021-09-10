package com.epam.test.automation.java.practice5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.IntStream;

public class ArrayRectangles {

    private final Rectangle[] rectangles;

    public ArrayRectangles(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.rectangles = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        this.rectangles = rectangles;
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i] == null) {
                rectangles[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int numberMaxArea() {

        return IntStream.range(0, rectangles.length)
                .mapToObj(i -> {
                            if (null == rectangles[i]) {
                                return new Pair(i);
                            }
                            var value = rectangles[i].area();
                            return new Pair(i, value);
                        }
                ).filter(Pair::isValuePresent)
                .max(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);

    }

    public int numberMinPerimeter() {

        return IntStream.range(0, rectangles.length)
                .mapToObj(i -> {
                            if (null == rectangles[i]) {
                                return new Pair(i);
                            }
                            var value = rectangles[i].perimeter();
                            return new Pair(i, value);
                        }
                ).filter(Pair::isValuePresent)
                .min(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int numberSquares() {
        return (int) Arrays.stream(rectangles)
                .filter(Objects::nonNull)
                .filter(Rectangle::isSquare)
                .count();
    }

    public static class Pair {
        private final int num;
        private Double value;

        public Pair(int num) {
            this.num = num;
        }

        public Pair(int num, double value) {
            this.num = num;
            this.value = value;
        }

        public boolean isValuePresent() {
            return null != value;
        }

        public int getNum() {
            return num;
        }

        public double getValue() {
            return value;
        }
    }
}
