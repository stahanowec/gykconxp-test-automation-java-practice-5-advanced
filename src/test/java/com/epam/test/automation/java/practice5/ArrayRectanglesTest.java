package com.epam.test.automation.java.practice5;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class ArrayRectanglesTest {

    private ArrayRectangles rectangles;

    @BeforeMethod
    public void init() {
        this.rectangles = new ArrayRectangles(new Rectangle[5]);
        this.rectangles.addRectangle(getDefaultReactangle());
    }

    @Test
    public void ifAddRectangleWhenOutOfBoundaryThenFalse() {
        // given
        var rectangle = getRectangle(2, 2);
        IntStream.range(0, 5).forEach(i -> rectangles.addRectangle(getRectangle(i + 1, i + 1)));
        //when
        var result = rectangles.addRectangle(rectangle);
        //then
        assertFalse(result);
    }

    @Test
    public void ifCountThenSucess() {
        // given
        var rectangle = getRectangle(2, 2);
        var rectangle1 = getRectangle(3, 3);
        //when
        rectangles.addRectangle(rectangle);
        rectangles.addRectangle(rectangle1);
        var result = rectangles.numberSquares();
        //then
        assertEquals(2, result);
    }

    @Test
    public void ifMaxAreaThenSuccess() {
        // given
        var rectangle = getRectangle(2, 2);
        var rectangle1 = getRectangle(7, 3);
        //when
        rectangles.addRectangle(rectangle);
        rectangles.addRectangle(rectangle1);
        var result = rectangles.numberMaxArea();
        //then
        assertEquals(2, result);
    }

    @Test
    public void ifMinPerimeterThenSuccess() {
        // given
        var rectangle = getRectangle(2.0, 2.0);
        var rectangle1 = getRectangle(7.0, 3.0);
        //when
        rectangles.addRectangle(rectangle);
        rectangles.addRectangle(rectangle1);
        var result = rectangles.numberMinPerimeter();
        //then
        assertEquals(1, result);
    }

    @Test
    public void ifArrayRectangleWithEmptyConstructorMaxArea() {
        //given
        var arrayRectangles = new ArrayRectangles(5);
        //when then
        assertThrows(IllegalArgumentException.class, arrayRectangles::numberMaxArea);
    }

    @Test
    public void ifArrayRectangleWithEmptyConstructorMinPerimeter() {
        //given
        var arrayRectangles = new ArrayRectangles(5);
        //when then
        assertThrows(IllegalArgumentException.class, arrayRectangles::numberMinPerimeter);
    }

    private Rectangle getRectangle(double a, double b) {
        return new Rectangle(a, b);
    }

    private Rectangle getDefaultReactangle() {
        return new Rectangle();
    }

}