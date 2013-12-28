package com.bstu.sisanaliz;

public abstract class AbstractFunction implements Function {
    private int countCallFunction = 0;

    protected abstract double getFunctionValue(Point point);

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

    protected double sqr(double a) {
        return Math.pow(a, 2);
    }
}
