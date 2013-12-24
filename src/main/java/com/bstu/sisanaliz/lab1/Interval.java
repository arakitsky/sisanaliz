package com.bstu.sisanaliz.lab1;

public class Interval {

    public Interval(double x1, double x2, ExtremaType extremaType) {
        this.x1 = x1;
        this.x2 = x2;
        this.extremaType = extremaType;
    }

    private double x1;
    private double x2;
    private ExtremaType extremaType;

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public ExtremaType getExtremaType() {
        return extremaType;
    }
}
