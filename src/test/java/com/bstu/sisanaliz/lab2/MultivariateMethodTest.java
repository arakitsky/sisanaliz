package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
            double x3 = values[2];
            return sqr(x1)+sqr(x2)+sqr(x3)+1;
        }

        @Override
        public Point getAntiGradient(Point point) {
            double[] values = point.getValues();
            double x1 = values[0];
            double x2 = values[1];
            double x3 = values[2];
            return Point.createPint(-2*x1,-2*x2,-2*x3);
        }
    }


    @BeforeMethod
    public void setUp() {
        multivariateMethod = new MultivariateMethod();
    }

    @Test
    public void testGetExtremumMin() {
        Point extremum = multivariateMethod.getExtremum(new Lab2MinFunction(), Point.createPint(-10, -10, -10), ExtremumType.MIN, E);
        assertTrue(extremum.equals(Point.createPint(1.0, 1.0, 1.0),E));
    }

    @Test
    public void testGetExtremumMax() {
        throw new NotImplementedException();
    }
}
