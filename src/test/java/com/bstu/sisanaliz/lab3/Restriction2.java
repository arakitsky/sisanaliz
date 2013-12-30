package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;

//x1^2+x2
public class Restriction2 extends Restriction {
    @Override
    protected double getFunction(Point point) {
        double[] values = point.getValues();
        double x1 = values[0];
        double x2 = values[1];
        return x1*x1+x2;
    }

    @Override
    protected Point getGradient(Point point) {
        double[] values = point.getValues();
        double x1 = values[0];
        return Point.createPoint(2 * x1,0);
    }
}
