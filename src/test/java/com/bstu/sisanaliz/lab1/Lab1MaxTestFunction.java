package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

public class Lab1MaxTestFunction extends AbstractFunction implements Function {


    @Override
    protected double getFunctionValue(Point array) {
        return -1*Math.pow(array.getValue()[0],2);
    }

}
