package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.ExtremaType;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.Point;

import java.util.Random;

public class SimpleMethod {

    public static final Random RANDOM = new Random();

    /**
     * Результат сравнения 3х точек
     * (maxA maxB) больший орезок. Min - минимальная точка
     */
    class ComparePointResult {
        ComparePointResult(Point maxA, Point maxB,boolean axMax) {
            this.maxA = maxA;
            this.maxB = maxB;
            this.axMax = axMax;
        }

        private Point maxA, maxB;
        private boolean axMax;

        public Point getMaxA() {
            return maxA;
        }

        public Point getMaxB() {
            return maxB;
        }
        boolean isAxMax() {
            return axMax;
        }

        @Override
        public String toString() {
            return "ComparePointResult{" +
                    "maxA=" + maxA +
                    ", maxB=" + maxB +
                    ", axMax=" + axMax +
                    '}';
        }
    }

    public Point getExtremum(Function function, Point startPoint, Point endPoint, ExtremaType extremaType, double e) {
        Point a = startPoint;
        Point b = endPoint;
        int iteration = 0;
        do{
            iteration++;
            Point x = getX(a, b);
            ComparePointResult bigVector = comparePoint(function,a, b, x);
            Point s = getRandom(bigVector.getMaxA(),bigVector.getMaxB());
            double fs = function.getValue(s);
            double fx = function.getValue(x);
            if(
                    (fx>=fs && extremaType.equals(ExtremaType.MAX)) ||
                    (fx<=fs && extremaType.equals(ExtremaType.MIN))
            ){
                if(bigVector.isAxMax()){
                  a=s;
                } else {
                  b=s;
                }
//                printLog(iteration,"1.fb>fs",a, b,x,s);
            } else {
                if(bigVector.isAxMax()){
                    b=x;
                } else {
                    a=x;
                }
//                printLog(iteration, "2.fb<fs",a, b, x, s);
            }

        }while ((b.minus( a).module()) > e) ;
        printLog(iteration, "END",a,b, null, null);
        return a.plus(b).multiply(1.0/2.0);
    }

    private void printLog(int iteration, String s, Point a, Point b, Point x, Point v) {
        System.out.println(iteration + ",\t" + s + " ,\ta=" + a + ",\tb=" + b + ",\tx=" + x + ",\tv=" + v);
    }

    private Point getX(Point startPoint, Point endPoint) {
        return getRandom(startPoint,endPoint);
//        return startPoint+(endPoint-startPoint)/2;
    }

    private Point getRandom(Point a, Point b) {
        return a.plus(b.minus(a).multiply(RANDOM.nextDouble()));
    }

    private ComparePointResult comparePoint(Function function, Point a, Point b, Point x) {
        double moduleAX = getModuleVector(a, x);
        double moduleXB = getModuleVector(x, b);
        if (moduleAX < moduleXB) {
            return new ComparePointResult(a, x,true);
        }
        return new ComparePointResult(x, b,false);
    }

    double getModuleVector(Point x1, Point x2) {
        return Math.abs(x1.module() - x2.module());
    }
}
