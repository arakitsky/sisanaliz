package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import static java.lang.Math.*;

public class Lab1Fuction implements Function {
    public static final double H = 4.842;
    public static final double G = 2.684;

    @Override
    public double getFunction(double x){
        return (H*sin(2*x)*pow(Math.E, sqr(cos(x)))*atan(sqrt(2.71+ sqr(x)))-0.02)/(G*pow(atan(sqrt(1.56+ sqr(x))),4)+log1p(1+atan(sqrt(5.24+sqr(x)))));
    }

    private double sqr(double x) {
        return pow(x,2);
    }
}