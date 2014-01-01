package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.lab2.Lab2Function;
import com.bstu.sisanaliz.lab3.restrictions.Restriction1;
import com.bstu.sisanaliz.lab3.restrictions.Restriction2;
import com.bstu.sisanaliz.lab3.restrictions.Restriction3;
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
 * Date: 02.01.14
 * Time: 2:07
 * To change this template use File | Settings | File Templates.
 */
public class Lab3RealFunctionTest {

    public static final double E = 1e-2;
    private Lab3FineFunction lab3FineFunction;
    private Lab3Function lab3Function;

    @BeforeMethod
    public void init() {
        ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
        restrictions.add(new Restriction1());
        restrictions.add(new Restriction2());
        restrictions.add(new Restriction3());
        lab3FineFunction = new Lab3FineFunction(restrictions);

        lab3Function = new Lab3Function(new Lab2Function(), new Lab3FineFunction(new ArrayList<Restriction>() {
            {
                add(new Restriction1());
                add(new Restriction2());
                add(new Restriction3());
            }
        }));
    }


    @DataProvider(name = "functionValue")
    public Object[][] createData(Method m) {
        System.out.println(m.getName());
        return new Object[][]{
                new Object[]{Point.createPoint(-10, -1, -1), Point.createPoint(0.23007, -0.176977, -0.0176977), 9.45485},
                new Object[]{Point.createPoint(-1, -1, -1), Point.createPoint(0,0,0), 0},
                new Object[]{Point.createPoint(15, 15, 15), Point.createPoint(-0.103881,-0.102801,0.0771224), 11.4361},

        };
    }

    @DataProvider(name = "lab3")
    public Object[][] createDataLab3(Method m) {
        System.out.println(m.getName());
        return new Object[][]{
                new Object[]{Point.createPoint(15, 15, 15), Point.createPoint(-389.104,-213.103,-74.9229), 5216.44},
//                new Object[]{Point.createPoint(15, 15, 15), Point.createPoint(0.103881,0.102801,-0.0771224), 11.4361},

        };
    }

    @Test(dataProvider = "functionValue")
    public void testGetFunctionValue(Point point, Point gradientPoint, double value) throws Exception {
        double functionValue = lab3FineFunction.getFunctionValue(point);
        assertEquals(functionValue, value, E);
        Point antiGradient = lab3FineFunction.getAntiGradient(point);
        assertTrue(antiGradient.equals(gradientPoint, E));

    }

    @Test(dataProvider = "lab3")
       public void testLab3Function(Point point, Point gradientPoint, double value) throws Exception {
        double functionValue = lab3Function.getFunctionValue(point);
        assertEquals(functionValue, value, E);
    }

    @Test(dataProvider = "lab3")
    public void testLab3Gradient(Point point, Point gradientPoint, double value) throws Exception {
        Point antiGradient = lab3Function.getAntiGradient(point);
        assertTrue(antiGradient.equals(gradientPoint, E));

    }

}
