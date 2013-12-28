package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import com.bstu.sisanaliz.Interval;
import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.AbstractFunction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Math.sin;
import static org.junit.Assert.*;


public class FunctionTabulationServiceTest  {

    private FunctionTabulationService functionTabulationService;
    private FunctionTabulationServiceTest.MockFunctionStatigy mockFunctionStatigy;

    @BeforeMethod
    public void init(){
        functionTabulationService = new FunctionTabulationService();
        mockFunctionStatigy = new MockFunctionStatigy();
    }

    class MockFunctionStatigy extends AbstractFunction implements Function {

        protected double getFunctionValue(Point array) {
            return sin(array.getValue()[0]);
        }


    }

    @Test
    public void testGetTabulation() {

        List<Interval> tabulation = functionTabulationService.getTabulation(mockFunctionStatigy, new Point(new double[]{-10.0}), new Point(new double[]{10.0}), 100);
        assertEquals(tabulation.size(), 6);
    }
 
}
