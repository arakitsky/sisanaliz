package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Point;

public class Lab1MinTestFunction extends AbstractFunction {

    @Override
    protected double getFunctionValue(Point point) {
        return 1*Math.pow(point.getValues()[0],2);
    }

}
