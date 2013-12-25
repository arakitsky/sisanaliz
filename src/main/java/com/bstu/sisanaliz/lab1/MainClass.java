package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import java.util.List;

public class MainClass {


    public static final double E = 10e-4;
    public static final double startPoint = -10;
    public static final double endPoint = 10;
    public static final int countSteps = 100;

    public MainClass() {
        functionTabulationService = new FunctionTabulationService();
        function = new Lab1TestFunction();
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
            mainClass.getSimpleMethod().getExtremum(mainClass.getFunction(), interval.getX1(), interval.getX2(), ExtremaType.MIN, E);
        }

    }
}
