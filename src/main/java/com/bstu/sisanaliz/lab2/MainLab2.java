package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.lab1.SimpleMethod;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 28.12.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class MainLab2 {

    public static void main(String[] args) {
        Lab2Function lab2Function = new Lab2Function();
        MultivariateMethod multivariateMethod = new MultivariateMethod(new SimpleMethod());
        Point extremum = multivariateMethod.getExtremum(lab2Function, Point.createPoint(0, 0, 0), ExtremumType.MIN, 1e-4);
        System.out.println(extremum);
        System.out.println(lab2Function.getValue(extremum));

    }
}
