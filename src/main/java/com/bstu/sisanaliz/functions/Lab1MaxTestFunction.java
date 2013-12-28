package com.bstu.sisanaliz.functions;

import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

public class Lab1MaxTestFunction extends AbstractFunction implements Function {


    @Override
    protected double getFunctionValue(Point array) {
        return -1*Math.pow(array.getValue()[0],2);
    }

}
