package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

public class Lab1MaxTestFunction extends AbstractFunction implements Function {


    @Override
    protected double getFunctionValue(Point point) {
        return -1*Math.pow(point.getValues()[0],2);
    }

}
