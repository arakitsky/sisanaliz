package com.bstu.sisanaliz;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 27.12.13
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class PointTest {

    public static final double E = 1e-5;

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point6;
    private Point point1234;
    private Point point6001;

    @BeforeMethod
    public void init() {
        point1 = Point.createPint(1.0, 1.0, 1.0, 1.0);
        point2 = Point.createPint(2.0, 2.0, 2.0, 2.0);
        point3 = Point.createPint(3.0, 3.0, 3.0, 3.0);
        point6 = Point.createPint(6.0, 6.0, 6.0, 6.0);
        point1234 = Point.createPint(1.0, 2.0, 3.0, 4.0);
        point6001 = Point.createPint(6.0001, 6.0001, 6.0001, 6.0001);

    }

    @Test
    public void testMinus() throws Exception {
        assertTrue(point3.minus(point2).equals(point1, E));
    }

    @Test
    public void testPlus() throws Exception {
        assertTrue(point1.plus(point2).equals(point3, E));
    }

    @Test
    public void testMoreFalse() throws Exception {
        assertFalse(point2.more(point3));
    }

    @Test
    public void testMoreTrue() throws Exception {
        assertTrue(point3.more(point2));
    }

    @Test
    public void testModule() throws Exception {
        assertEquals(point1234.module(), 5.477225575,E);
    }

    @Test
    public void equalsTestTrue() {
        assertTrue(point6.equals(point6001, 0.1));
    }

    @Test
    public void equalsTestFalse() {
        assertFalse(point6.equals(point6001, 0.00001));
    }

    @Test
    public void multiplyTest(){
        assertTrue(point1.multiply(6).equals(point6,E));
    }

    @Test
    public void divideTest(){
        assertTrue(point6.divide(2).equals(point3,E));
    }
}
