package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.MultivariateFunction;
import com.bstu.sisanaliz.Point;

//function x1^2+x2^2+x2
public class TestFunction extends AbstractFunction implements MultivariateFunction {

    @Override
    public Point getAntiGradient(Point point) {
        double[] values = point.getValues();
        double x1 = values[0];
        double x2 = values[1];
        return Point.createPoint(2 * x1, 2 * x2 + 1);
    }

    @Override
    protected double getFunctionValue(Point point) {
        double[] values = point.getValues();
        double x1 = values[0];
        double x2 = values[1];
        return sqr(x1) + sqr(x2) + x2;
    }
}