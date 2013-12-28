package com.bstu.sisanaliz;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Point;

public class Interval {

    public Interval(Point x1, Point x2, ExtremumType extremumType) {
        this.x1 = x1;
        this.x2 = x2;
        this.extremumType = extremumType;
    }

    private Point x1;
    private Point x2;
    private ExtremumType extremumType;

    public Point getX1() {
        return x1;
    }

    public Point getX2() {
        return x2;
    }

    public ExtremumType getExtremumType() {
        return extremumType;
    }


    @Override
    public String toString() {
        return "Interval{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", extremumType=" + extremumType +
                '}';
    }
}
