package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

public class Lab1TestFunction implements Function {
    @Override
    public double getFunction(double x) {
        return -1*Math.pow(x,2);
    }
}
