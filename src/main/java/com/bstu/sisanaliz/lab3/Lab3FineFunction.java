package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.Point;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 0:56
 * To change this template use File | Settings | File Templates.
 */
public class Lab3FineFunction extends RestrictionFunction {

    protected Lab3FineFunction(List<Restriction> restrictionList) {
        super(restrictionList);
    }

    @Override
    protected double getFunctionValue(Point point) {
        double sum = getSumRestrictionFunctions(point);
        return Math.log(1+sum);


    }

    private double getSumRestrictionFunctions(Point point) {
        double sum=0;
        for (Restriction restriction : getRestrictionList()) {
            sum+=Math.pow(restriction.getValue(point),2);
        }
        return sum;
    }

    @Override
    public Point getAntiGradient(Point point) {
        double v = 1 / (1+getSumRestrictionFunctions(point));
        Point result = Point.createNullPoint(point.getValues().length);
        for (Restriction restriction : getRestrictionList()) {
            result=result.plus(restriction.getGradientValue(point).multiply(2*restriction.getValue(point)));
        }
        return result.multiply(v);
    }
}
