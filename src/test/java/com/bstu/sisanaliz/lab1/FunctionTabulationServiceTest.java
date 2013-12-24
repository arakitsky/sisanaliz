package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

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

    class MockFunctionStatigy implements Function {

        @Override
        public double getFunction(double x) {
            return sin(x);
        }
    }

    @Test
    public void testGetTabulation() {

        List<Interval> tabulation = functionTabulationService.getTabulation(mockFunctionStatigy, -10.0, 10.0, 100);
        assertEquals(tabulation.size(), 6);
    }
 
}
