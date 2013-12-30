package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.*;
import com.bstu.sisanaliz.lab1.SimpleMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultivariateMethodTest {


    public static final double E = 1e-4;
    private MultivariateMethod multivariateMethod;

    class Lab2MinFunction extends AbstractFunction implements MultivariateFunction{

        @Override
        protected double getFunctionValue(Point point) {
            double[] values = point.getValues();
            double x1 = values[0];
            double x2 = values[1];
            return sqr(x1)+sqr(x2)+x2;
        }

        @Override
        public Point getAntiGradient(Point point) {
            double[] values = point.getValues();
            double x1 = values[0];
            double x2 = values[1];
            return Point.createPoint(-2 * x1, -2 * x2 - 1);
        }
    }


    @BeforeMethod
    public void setUp() {
        multivariateMethod = new MultivariateMethod(new SimpleMethod());
    }

    @Test
    public void testGetExtremumMin() {
        Lab2MinFunction function = new Lab2MinFunction();
        Point extremum = multivariateMethod.getExtremum(function, Point.createPoint(0, 0), ExtremumType.MIN, E);
        System.out.println(extremum);
        System.out.println(function.getValue(extremum));
        System.out.println(function.getValue(Point.createPoint(0, -0.5)));
        assertEquals(function.getFunctionValue(extremum),-0.25,E);
    }

    @Test(enabled = false)
    public void testGetExtremumMax() {
        throw new NotImplementedException();
    }


}
