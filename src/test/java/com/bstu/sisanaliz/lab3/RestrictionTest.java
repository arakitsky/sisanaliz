package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.testng.Assert.assertEquals;

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
        Restriction restriction = createRestriction(-3, 5);
        double value = restriction.getValue(Point.createPint());
        assertEquals(value,0, E);
    }

    private Restriction createRestriction(final double functionValue, final double gradientValue) {
        return new Restriction() {

            @Override
            protected double getFunction(Point point) {
                return functionValue;
            }

            @Override
            protected double getGradient(Point point) {
                return gradientValue;
            }
        };
    }

    @Test
    public void testGetGradientValueNull()  {
        final double i=3;
        Restriction restriction = createRestriction(3, -5);
        double value = restriction.getGradientValue(Point.createPint());
        assertEquals(value,0, E);
    }

    @Test
    public void testGetGradientValueMax()  {
        final double i=3;
        Restriction restriction = createRestriction(-3, 5);
        double value = restriction.getGradientValue(Point.createPint());
        assertEquals(value,5, E);
    }

    @Test
    public void testGetValueMax(){
        final double i=3;
        Restriction restriction = createRestriction(3, -5);
        double value = restriction.getValue(Point.createPint());
        assertEquals(value,3, E);
    }
}
