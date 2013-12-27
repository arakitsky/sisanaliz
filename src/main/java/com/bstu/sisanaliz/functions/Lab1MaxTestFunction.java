package com.bstu.sisanaliz.functions;

import com.bstu.sisanaliz.Function;

public class Lab1MaxTestFunction extends AbstractFunction implements Function {


    @Override
    protected double getFunctionValue(double x) {
        return -1*Math.pow(x,2);
    }

}
