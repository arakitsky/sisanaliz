package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremaType;
import com.bstu.sisanaliz.Point;

public class Interval {

    public Interval(Point x1, Point x2, ExtremaType extremaType) {
        this.x1 = x1;
        this.x2 = x2;
        this.extremaType = extremaType;
    }

    private Point x1;
    private Point x2;
    private ExtremaType extremaType;

    public Point getX1() {
        return x1;
    }

    public Point getX2() {
        return x2;
    }

    public ExtremaType getExtremaType() {
        return extremaType;
    }


    @Override
    public String toString() {
        return "Interval{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", extremaType=" + extremaType +
                '}';
    }
}
