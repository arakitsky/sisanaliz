package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

import java.util.List;

public class MainClass {


    public static final double E = 10e-4;
    public static final Point startPoint = new Point(new double[]{0});
    public static final Point endPoint = new Point(new double[]{2.6});
    public static final int countSteps = 100;

    public MainClass() {
        functionTabulationService = new FunctionTabulationService();
        function = new Lab1Fuction();
        simpleMethod = new SimpleMethod();
    }

    private FunctionTabulationService functionTabulationService;
    private Function function;
    private SimpleMethod simpleMethod;

    public FunctionTabulationService getFunctionTabulationService() {
        return functionTabulationService;
    }

    public Function getFunction() {
        return function;
    }

    public SimpleMethod getSimpleMethod() {
        return simpleMethod;
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        int iter = 0;
        List<Interval> tabulation = mainClass.getFunctionTabulationService().getTabulation(mainClass.getFunction(), startPoint, endPoint, countSteps);
        for (Interval interval : tabulation) {
            System.out.println(++iter);
            Point extremum = mainClass.getSimpleMethod().getExtremum(mainClass.getFunction(), interval.getX1(), interval.getX2(), ExtremumType.MIN, E);
            System.out.println(interval + " point = " + extremum + ", function = " + mainClass.getFunction().getCountCallFunction());
        }

    }
}
