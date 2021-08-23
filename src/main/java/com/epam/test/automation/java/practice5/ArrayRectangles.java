package com.epam.test.automation.java.practice5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.IntStream;

public class ArrayRectangles {

    private Rectangle[] rectangleArray;

    public ArrayRectangles(int n) {
        this.rectangleArray = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle[] n) {
        this.rectangleArray = n;
    }


    public boolean addRectangle(Rectangle rectangle) {
        var pairStream = IntStream.range(0, rectangleArray.length)
                .filter(element -> rectangleArray[element] == null)
                .findFirst();

        if (pairStream.isPresent()) {
            this.rectangleArray[pairStream.getAsInt()] = rectangle;
            return true;
        }
        return false;
    }

    public int numberMaxArea() {

        return IntStream.range(0, rectangleArray.length)
                .filter(element -> rectangleArray[element] != null)
                .mapToObj(i -> {
                            var value = rectangleArray[i].area();
                            return new Pair(i, value);
                        }
                ).max(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);

    }

    public int numberMinPerimeter() {
        return IntStream.range(0, rectangleArray.length)
                .filter(element -> rectangleArray[element] != null)
                .mapToObj(i -> {
                            var value = rectangleArray[i].perimeter();
                            return new Pair(i, value);
                        }
                ).min(Comparator.comparing(Pair::getValue))
                .map(Pair::getNum)
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int numberSquares() {
        return (int) Arrays.stream(rectangleArray)
                .filter(Objects::nonNull)
                .filter(Rectangle::isSquare)
                .count();
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
