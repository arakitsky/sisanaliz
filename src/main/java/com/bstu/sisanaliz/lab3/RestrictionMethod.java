package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.ExtremumType;
import com.bstu.sisanaliz.Point;
import com.bstu.sisanaliz.lab2.MultivariateMethod;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 3:37
 * To change this template use File | Settings | File Templates.
 */
public class RestrictionMethod {

    private MultivariateMethod multivariateMethod;

    public RestrictionMethod(MultivariateMethod multivariateMethod) {
        this.multivariateMethod = multivariateMethod;
    }

    public Point getValue(Lab3Function function, Point startPoint, double e){
        Point newPoint = startPoint;
        Point oldPoint;
        int iter = 0;
        do{
            iter++;
            oldPoint = newPoint;
            newPoint= multivariateMethod.getExtremum(function, newPoint, ExtremumType.MIN, e);
//            function.nextIterationFunction();
            System.out.println("\ni="+iter+".x="+newPoint+"function="+function.getValue(newPoint));
        }while (newPoint.minus(oldPoint).module()>e);
        System.out.println("Конец.");
        System.out.println("\n\nx="+newPoint+"function="+function.getValue(newPoint));

        return newPoint;
    }
}
