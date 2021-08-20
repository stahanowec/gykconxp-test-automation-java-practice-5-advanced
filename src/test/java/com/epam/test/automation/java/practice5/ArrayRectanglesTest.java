package com.epam.test.automation.java.practice5;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ArrayRectanglesTest {

    private ArrayRectangles rectangles;

    @BeforeMethod
    public void init(){
        this.rectangles = new ArrayRectangles(5);
        this.rectangles.addRectangle(getDefaultReactangle());
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
        var rectangle = getRectangle(2, 2);
        var rectangle1 = getRectangle(7, 3);
        //when
        rectangles.addRectangle(rectangle);
        rectangles.addRectangle(rectangle1);
        var result = rectangles.numberMinPerimeter();
        //then
        assertEquals(1, result);
    }


    private Rectangle getRectangle(double a, double b){
        return new Rectangle(a,b);
    }

    private Rectangle getDefaultReactangle() {
        return new Rectangle();
    }
}