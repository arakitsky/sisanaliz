package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.lab1.SimpleMethod;
import com.bstu.sisanaliz.lab2.Lab2Function;
import com.bstu.sisanaliz.lab2.MultivariateMethod;
import com.bstu.sisanaliz.lab3.restrictions.Restriction1;
import com.bstu.sisanaliz.lab3.restrictions.Restriction2;
import com.bstu.sisanaliz.lab3.restrictions.Restriction3;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 3:48
 * To change this template use File | Settings | File Templates.
 */
public class RestrictionMethodTest {

    private RestrictionMethod restrictionMethod;
    private Lab3Function lab3Function;

    @BeforeMethod
    public void setUp()  {
        SimpleMethod simpleMethod = new SimpleMethod();
        MultivariateMethod multivariateMethod = new MultivariateMethod(simpleMethod);
        restrictionMethod = new RestrictionMethod(multivariateMethod);
        lab3Function = new Lab3Function(new Lab2Function(), new Lab3FineFunction(new ArrayList<Restriction>() {
            {
                add(new Restriction1());
                add(new Restriction2());
                add(new Restriction3());
            }
        }));

    }

    @Test
    public void testGetValue()  {
        Point restrictionMethodValue = restrictionMethod.getValue(lab3Function, Point.createNullPoint(3), 1e-3);
        System.out.println(restrictionMethodValue);
    }
}
