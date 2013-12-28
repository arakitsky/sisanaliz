package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.functions.AbstractFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.lang.Math.sin;
import static org.junit.Assert.*;


public class FunctionTabulationServiceTest  {

    private FunctionTabulationService functionTabulationService;
    private FunctionTabulationServiceTest.MockFunctionStatigy mockFunctionStatigy;

    @Before
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
