package com.bstu.sisanaliz.lab3.restrictions;

import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.lab3.Restriction;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 3:52
 * To change this template use File | Settings | File Templates.
 */
public class Restriction3 extends Restriction {
    @Override
    protected double getFunction(Point point) {
        double[] values = point.getValues();
        double x3 = values[2];
        double x2 = values[1];
        double x1 = values[0];
        return 12 * x1 + 14 * x2 - 9 * x3 + 12;
    }

    @Override
    protected Point getGradient(Point point) {
        return Point.createPoint(12, 14, -9).multiply(-1);
    }
}
