package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 30.12.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public abstract class Restriction {
    public double getValue(Point point) {
        double functionValue = getFunction(point);
        return functionValue > 0 ? functionValue : 0;
    }

    public double getGradientValue(Point point){
        double functionValue = getGradient(point);
        return functionValue > 0 ? functionValue : 0;
    }

    protected abstract double getFunction(Point point);

    protected abstract double getGradient(Point point);
}
