package com.bstu.sisanaliz.lab1;

import com.bstu.sisanaliz.Function;

import java.util.Random;

public class SimpleMethod {

    public static final Random RANDOM = new Random();

    /**
     * Результат сравнения 3х точек
     * (maxA maxB) больший орезок. Min - минимальная точка
     */
    class ComparePointResult {
        ComparePointResult(double maxA, double maxB,double min) {
            this.maxA = maxA;
            this.maxB = maxB;
            this.min = min;
        }

        private double maxA, maxB, min;

        public double getMaxA() {
            return maxA;
        }

        public double getMaxB() {
            return maxB;
        }

        public double getMin() {
            return min;
        }
    }

    public double getExtremum(Function function, double startPoint, double endPoint, ExtremaType extremaType, double e) {
        double a = startPoint;
        double b = endPoint;
        do{
            double x = getX(a, b);
            ComparePointResult bigVector = comparePoint(a, b, x);
            double s = getRandom(bigVector.getMaxA(),bigVector.getMaxB());
            double fs = function.getFunction(s);
            // for max
            double fminB = function.getFunction(bigVector.getMaxA());
            if(fminB>=fs){
                a= bigVector.getMin();
                b=s;
            } else {
                // что тут?
                a=x;
                b=bigVector.getMaxB();
            }

        }while ((b - a) > e) ;
        return 10;
    }

    private double getX(double startPoint, double endPoint) {
        return getRandom(startPoint,endPoint);
    }

    private double getRandom(double a, double b) {
        return a + RANDOM.nextDouble()*(b-a);
    }

    private ComparePointResult comparePoint(double a, double b, double x) {
        double moduleAX = getModuleVector(a, x);
        double moduleXB = getModuleVector(x, b);
        if (moduleAX > moduleXB) {
            return new ComparePointResult(a, x,b);
        }
        return new ComparePointResult(x, b,a);
    }

    double getModuleVector(double x1, double x2) {
        return Math.abs(x1 - x2);
    }
}
