package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Interval;
import com.bstu.sisanaliz.Point;

import java.util.ArrayList;
import java.util.List;

public class FunctionTabulationService {

    public List<Interval> getTabulation(Function function, Point startPoint, Point endPoint, int coutStaps) {
        //шаг
        Point h = endPoint.minus(startPoint).multiply(1.0 / coutStaps);
        Point stepX = startPoint;
        Point stepXh = startPoint.plus(h);
        Point stepX2h = startPoint.plus(h.multiply(2));
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        do {
            double fx = function.getValue(stepX);
            double fxh = function.getValue(stepXh);
            double fx2h = function.getValue(stepX2h);
            //функция максимума
            if ((fx < fxh && fxh > fx2h)) {
                intervals.add(new Interval(stepX, stepX2h, ExtremumType.MAX));
            }
            if ((fx > fxh) && fxh < fx2h) {
                intervals.add(new Interval(stepX, stepX2h, ExtremumType.MIN));
            }
            stepX = stepX.plus(h);
            stepXh = stepX.plus(h);
            stepX2h = stepXh.plus(h);
        } while (!stepX2h.more(endPoint));
        return intervals;
    }
}
