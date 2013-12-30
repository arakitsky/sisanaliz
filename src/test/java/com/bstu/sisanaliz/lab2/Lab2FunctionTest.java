package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 28.12.13
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class Lab2FunctionTest {

    public static final double E = 1e-10;
    private Lab2Function lab2Function;
    private Point pint567;

    @BeforeMethod
    public void init(){
        lab2Function = new Lab2Function();
        pint567 = Point.createPoint(5.0, 6.0, 7.0);
    }

    @Test
    public void testGetGradient(){
        Point expected = Point.createPoint(-157.0, -79.0, -27.0);
        assertTrue(lab2Function.getAntiGradient(pint567).equals(expected,E));
    }

    @Test
    public void testGetFunctionValue() {
        assertEquals(lab2Function.getFunctionValue(pint567),753, E);
    }
}
