package com.bstu.sisanaliz.lab2;

import com.bstu.sisanaliz.*;
import com.bstu.sisanaliz.lab1.SimpleMethod;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 28.12.13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class MultivariateMethod {

    public SimpleMethod simpleMethod;

    public MultivariateMethod(SimpleMethod simpleMethod) {
        this.simpleMethod = simpleMethod;
    }

    public Point getExtremum(MultivariateFunction function, Point startPoint, ExtremumType extremumType, double e) {
        int iteration = 0;
        Point point = startPoint;
        Point antiGradientPoint = function.getAntiGradient(point);
//        System.out.println("Iteration=" + iteration + ", Point=" + point + ", antiGradientPoint" + antiGradientPoint);
        double module;
        do {
            iteration++;
            point = simpleMethod.getExtremum(function, new Interval(point, antiGradientPoint.plus(point), extremumType), e);
            antiGradientPoint = function.getAntiGradient(point);
            module = antiGradientPoint.module();
//            System.out.println("Iteration=" + iteration + "module=" + module + ", Point=" + point + ", antiGradientPoint" + antiGradientPoint);
        } while (module > e);
//            System.out.println("Iteration=" + iteration + "module=" + module + ", Point=" + point + ", antiGradientPoint" + antiGradientPoint);

        return point;
    }
}
