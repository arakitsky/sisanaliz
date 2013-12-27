package com.bstu.sisanaliz;

public interface Function {
    public double getValue(double x);
    public double getAbsValue(double x);
    public int getCountCallFunction();
    public void setCountCallFunction(int countCallFunction);
}
