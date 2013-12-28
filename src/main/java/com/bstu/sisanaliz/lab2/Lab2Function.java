package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.MultivariateFunction;
import com.bstu.sisanaliz.Point;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 28.12.13
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */
public class Lab2Function extends AbstractFunction implements MultivariateFunction {
    @Override
    public Point getGradient(Point point) {
        double[] values = point.getValue();
        double x1 = values[0];
        double x2 = values[1];
        double x3 = values[2];
        return Point.createPint((29+18*x1+4*x2+2*x3),(3+4*x1+14*x2-4*x3),(-15+2*x1-4*x2+8*x3));
    }

    @Override
    protected double getFunctionValue(Point point) {
        double[] values = point.getValue();
        double x1 = values[0];
        double x2 = values[1];
        double x3 = values[2];
        return 9 * sqr(x1) + 7 * sqr(x2) + 4 * sqr(x3)+4*x1*x2+2*x1*x3-4*x2*x3+29*x1+3*x2-15*x3;
    }

}
