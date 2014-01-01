package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.MultivariateFunction;
import com.bstu.sisanaliz.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
public class Lab3Function extends AbstractFunction implements MultivariateFunction{

    private final MultivariateFunction function;
    private final RestrictionFunction restrictionFunction;

    protected Lab3Function(MultivariateFunction function, RestrictionFunction restrictionFunction) {
        this.function = function;
        this.restrictionFunction = restrictionFunction;
    }


    @Override
    protected double getFunctionValue(Point point) {
        int tau = restrictionFunction.getTau();
        return function.getValue(point)+tau*restrictionFunction.getValue(point);
    }

    @Override
    public Point getAntiGradient(Point point) {
        int tau = restrictionFunction.getTau();
        return function.getAntiGradient(point).plus(restrictionFunction.getAntiGradient(point).multiply(tau));
    }

    public void nextIterationFunction(){
        restrictionFunction.incrementTau();
    }
}
