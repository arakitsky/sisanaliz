package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Interval;
import com.bstu.sisanaliz.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class SimpleMethodTest {

    private SimpleMethod simpleMethod;
    private Lab1MaxTestFunction function;

    @BeforeMethod
    public void init() {
        simpleMethod = new SimpleMethod();
    }

    @Test
    public void getMaxTest() {
        double e = 10e-4;
        function = new Lab1MaxTestFunction();
        Interval interval = new Interval(new Point(new double[]{-10}), new Point(new double[]{10}), ExtremumType.MAX);
        Point extremum = simpleMethod.getExtremum(function, interval, e);
        System.out.println("f=" + function.getCountCallFunction());
        function.setCountCallFunction(0);
        assertEquals(extremum.getValues()[0], 0, e);
    }

    @Test
    public void getMinTest() {
        double e = 10e-4;
        Lab1MinTestFunction function = new Lab1MinTestFunction();
        Interval interval = new Interval(new Point(new double[]{-10}), new Point(new double[]{10}), ExtremumType.MIN);
        Point extremum = simpleMethod.getExtremum(function, interval, e);
        System.out.println("f=" + function.getCountCallFunction());
        assertEquals(extremum.getValues()[0], 0, e);
    }
}
