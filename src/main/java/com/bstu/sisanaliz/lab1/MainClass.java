package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.functions.Lab1Fuction;
import com.bstu.sisanaliz.functions.Lab1MaxTestFunction;

import java.util.List;

public class MainClass {


    public static final double E = 10e-4;
    public static final double startPoint = 0;
    public static final double endPoint = 2.6;
    public static final int countSteps = 10;

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
        List<Interval> tabulation = mainClass.getFunctionTabulationService().getTabulation(mainClass.getFunction(), startPoint, endPoint, countSteps);
        for (Interval interval : tabulation) {
            double extremum = mainClass.getSimpleMethod().getExtremum(mainClass.getFunction(), interval.getX1(), interval.getX2(), ExtremaType.MIN, E);
            System.out.println(interval + " point = " + extremum + ", function = " + mainClass.getFunction().getCountCallFunction());
        }

    }
}
