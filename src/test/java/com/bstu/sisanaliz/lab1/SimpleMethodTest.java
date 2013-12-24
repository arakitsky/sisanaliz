package com.bstu.sisanaliz.lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMethodTest {

    private SimpleMethod simpleMethod;

    @Before
    public void init(){
        simpleMethod = new SimpleMethod();
    }

    @Test
    public void getExtremumTest(){
        double e = 10e-4;
        double extremum = simpleMethod.getExtremum(new Lab1TestFunction(), -10, 10, e);
        assertEquals(extremum,0,e);
    }
}
