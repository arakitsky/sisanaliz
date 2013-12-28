package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremaType;
import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.functions.Lab1MaxTestFunction;
import com.bstu.sisanaliz.functions.Lab1MinTestFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMethodTest {

    private SimpleMethod simpleMethod;
    private Lab1MaxTestFunction function;

    @Before
    public void init(){
        simpleMethod = new SimpleMethod();
    }

    @Test
    public void getMaxTest(){
        double e = 10e-4;
        function = new Lab1MaxTestFunction();
        Point extremum = simpleMethod.getExtremum(function, new Point(new double[]{-10}),new Point(new double[]{10}), ExtremaType.MAX, e);
        System.out.println("f="+ function.getCountCallFunction());
        function.setCountCallFunction(0);
        assertEquals(extremum.getValue()[0], 0, e);
    }

    @Test
    public void getMinTest(){
        double e = 10e-4;
        Lab1MinTestFunction function = new Lab1MinTestFunction();
        Point extremum = simpleMethod.getExtremum(function, new Point(new double[]{-10}),new Point(new double[]{10}), ExtremaType.MIN, e);
        System.out.println("f="+ function.getCountCallFunction());
        assertEquals(extremum.getValue()[0], 0, e);
    }
}
