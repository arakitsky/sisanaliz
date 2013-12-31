package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 1:04
 * To change this template use File | Settings | File Templates.
 */
public class Lab3FineFunctionTest {

    public static final double E = 1e-3;
    private Lab3FineFunction lab3FineFunction;

    @BeforeMethod
    public void init() {
        ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
        restrictions.add(new Restriction1());
        restrictions.add(new Restriction2());
        lab3FineFunction = new Lab3FineFunction(restrictions);
    }


    @DataProvider(name = "functionValue")
    public Object[][] createData(Method m) {
        System.out.println(m.getName());
        return new Object[][]{
                new Object[]{Point.createPoint(3, -1), 4.39445},
                new Object[]{Point.createPoint(10, -10), 9.91349},
                new Object[]{Point.createPoint(-1, -10), 9.19034},
                new Object[]{Point.createPoint(1, -10), 9.23034},
                new Object[]{Point.createPoint(-10, 1), 9.23034},
                new Object[]{Point.createPoint(-1, -1), 0},
        };
    }

    @DataProvider(name = "gradientValues")
    public Object[][] createDataGradient(Method m) {
        System.out.println(m.getName());
        return new Object[][]{
                new Object[]{Point.createPoint(3, -1), Point.createPoint(1.28395, 0)},
                new Object[]{Point.createPoint(-1, 3), Point.createPoint(0, 1.28395)},
                new Object[]{Point.createPoint(3, 1), Point.createPoint(1.09402, 0.307692)},
                new Object[]{Point.createPoint(-3, -1), Point.createPoint(-1.47692, 0.246154)},
                new Object[]{Point.createPoint(0, 0), Point.createPoint(0, 0)},
                new Object[]{Point.createPoint(10, 10), Point.createPoint(0.190901, 0.190901)},
                new Object[]{Point.createPoint(-1, -1), Point.createPoint(0, 0)},
        };
    }

    @Test(dataProvider = "functionValue")
    public void testGetFunctionValue(Point point, double value) throws Exception {
        double functionValue = lab3FineFunction.getFunctionValue(point);
        assertEquals(functionValue, value, E);
    }

    @Test(dataProvider = "gradientValues")
    public void testGetAntiGradient(Point point, Point value) throws Exception {
        Point antiGradient = lab3FineFunction.getAntiGradient(point);
        assertTrue(antiGradient.equals(value, E));
    }

}
