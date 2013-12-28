package com.bstu.sisanaliz;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 27.12.13
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFunction implements Function {
    private int countCallFunction = 0;

    protected abstract double getFunctionValue(Point array);

    public double getValue(Point array) {
        countCallFunction++;
        return getFunctionValue(array);
    }

    public int getCountCallFunction() {
        return countCallFunction;
    }

    public void setCountCallFunction(int countCallFunction) {
        this.countCallFunction = countCallFunction;
    }
}
