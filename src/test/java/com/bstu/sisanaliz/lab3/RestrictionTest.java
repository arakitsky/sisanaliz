package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 30.12.13
 * Time: 23:55
 * To change this template use File | Settings | File Templates.
 */
public class RestrictionTest {

    public static final double E = 1e-4;

    @Test
    public void testGetValueNull() {
        final double i=3;
        Restriction restriction = createRestriction(-3, Point.createPoint(-5,3));
        double value = restriction.getValue(Point.createPoint());
        assertEquals(value,0, E);
    }

    private Restriction createRestriction(final double functionValue, final Point gradientValue) {
        return new Restriction() {

            @Override
            protected double getFunction(Point point) {
                return functionValue;
            }

            @Override
            protected Point getGradient(Point point) {
                return gradientValue;
            }
        };
    }

    @Test
    public void testGetGradientValueNull()  {
        Restriction restriction = createRestriction(-3,Point.createPoint(-5,3));
        Point value = restriction.getGradientValue(Point.createPoint(0,0));
        assertTrue(value.equals(Point.createPoint(0, 0), E));
    }

    @Test
    public void testGetGradientValueMax()  {
        final double i=3;
        Restriction restriction = createRestriction(3, Point.createPoint(5,-3));
        Point value = restriction.getGradientValue(Point.createPoint(0,0));
        assertTrue(value.equals(Point.createPoint(5, -3), E));
    }


    @Test
    public void testGetValueMax(){
        Restriction restriction = createRestriction(3, Point.createPoint(-5,3));
        double value = restriction.getValue(Point.createPoint());
        assertEquals(value,3, E);
    }
}
