package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Point;

public class Lab1MinTestFunction extends AbstractFunction {

    @Override
    protected double getFunctionValue(Point array) {
        return 1*Math.pow(array.getValue()[0],2);
    }

}
