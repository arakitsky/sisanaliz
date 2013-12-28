package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import com.bstu.sisanaliz.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Lab1FunctionTest {

    private Function function;

    @BeforeMethod
    public void init(){
        function = new Lab1Fuction();
    }

    @Test
    public void testGetFunction() {
        double function = this.function.getValue(new Point(new double[]{2}));
        assertEquals(function,-0.917556, MainClass.E);
    }
}
