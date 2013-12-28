package com.bstu.sisanaliz.functions;

import com.bstu.sisanaliz.Point;

public class Lab1MinTestFunction extends AbstractFunction {

    @Override
    protected double getFunctionValue(Point array) {
        return 1*Math.pow(array.getValue()[0],2);
    }

}
