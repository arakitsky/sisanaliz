package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import java.util.ArrayList;
import java.util.List;

public class FunctionTabulationService {

    public List<Interval> getTabulation(Function function, double start, double end, int coutStaps){
        //шаг
        double h = (end- start)/coutStaps;
        double stepX=start;
        double stepXh=start+h;
        double stepX2h=start+2*h;
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        do{
            double fx = function.getFunction(stepX);
            double fxh = function.getFunction(stepXh);
            double fx2h = function.getFunction(stepX2h);
            //функция максимума
            if((fx<fxh && fxh>fx2h) ){
                intervals.add(new Interval(stepX,stepX2h,ExtremaType.MAX));
            }
            if((fx>fxh) && fxh<fx2h){
                intervals.add(new Interval(stepX,stepX2h,ExtremaType.MIN));
            }
            stepX=stepX+h;
            stepXh=stepX+h;
            stepX2h=stepXh+h;
        }while (stepX2h<end);
        return intervals;
    }
}
