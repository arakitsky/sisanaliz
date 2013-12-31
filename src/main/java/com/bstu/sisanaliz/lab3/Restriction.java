package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;

public abstract class Restriction {
    public double getValue(Point point) {
        double functionValue = getFunction(point);
        return functionValue > 0 ? functionValue : 0;
    }

    private double getMaxZeroFunction(double functionValue) {
        return functionValue > 0 ? functionValue : 0;
    }

    public Point getGradientValue(Point point){
        return getFunction(point) > 0 ? getGradient(point) : Point.createNullPoint(point.getValues().length);
    }

    protected abstract double getFunction(Point point);

    protected abstract Point getGradient(Point point);
}
