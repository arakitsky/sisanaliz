package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lab1FunctionTest {

    private Function function;

    @Before
    public void init(){
        function = new Lab1Fuction();
    }

    @Test
    public void testGetFunction() {
        double function = this.function.getFunction(2);
        assertEquals(function,-0.84772500665, MainClass.E);
    }
}