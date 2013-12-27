package com.bstu.sisanaliz.functions;

import com.bstu.sisanaliz.Function;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 27.12.13
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFunction implements Function {
    private int countCallFunction=0;

    @Override
    public double getAbsValue(double x) {
        return Math.abs(getValue(x)) ;
    }

    protected abstract double getFunctionValue(double x);

    public double getValue(double x){
        countCallFunction++;
        return getFunctionValue(x);
    }

    public int getCountCallFunction() {
        return countCallFunction;
    }

    public void setCountCallFunction(int countCallFunction) {
        this.countCallFunction = countCallFunction;
    }
}
