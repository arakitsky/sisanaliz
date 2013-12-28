package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

import static java.lang.Math.*;

public class Lab1Fuction extends AbstractFunction implements Function {

    public static final double H = 4.842;
    public static final double G = 2.628;

    protected double getFunctionValue(Point point) {
        double x = point.getValues()[0];
        return (H * sin(2 * x) * pow(Math.E, sqr(cos(x))) * atan(sqrt(2.71 + sqr(x))) - 0.02) / (G * pow(atan(sqrt(1.56 + sqr(x))), 4) + log(1 + atan(sqrt(5.24 + sqr(x)))));
    }
}
