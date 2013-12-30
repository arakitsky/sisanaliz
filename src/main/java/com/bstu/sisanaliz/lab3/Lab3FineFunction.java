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
        double sum=0;
        for (Restriction restriction : getRestrictionList()) {
            sum+=Math.pow(restriction.getValue(point),2);
        }
        return getTau()*Math.log(1+sum);


    }

    @Override
    public Point getAntiGradient(Point point) {
//        double v = 1 / getFunctionValue(point);
//        for (Restriction restriction : getRestrictionList()) {
//            restriction.getGradientValue(point)
//        }
//        return v;
        return null;
    }
}
