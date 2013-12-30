package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;

public abstract class Restriction {
    public double getValue(Point point) {
        double functionValue = getFunction(point);
        return getMaxZeroFunction(functionValue);
    }

    private double getMaxZeroFunction(double functionValue) {
        return functionValue > 0 ? functionValue : 0;
    }

    public Point getGradientValue(Point point){
        Point functionValue = getGradient(point);
        double[] values = functionValue.getValues();
        double[] newValues = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = getMaxZeroFunction(values[i]);
        }
        return new Point(newValues);
    }

    protected abstract double getFunction(Point point);

    protected abstract Point getGradient(Point point);
}
