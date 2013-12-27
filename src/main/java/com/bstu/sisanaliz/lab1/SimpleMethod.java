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
        ComparePointResult(double maxA, double maxB,boolean axMax) {
            this.maxA = maxA;
            this.maxB = maxB;
            this.axMax = axMax;
        }

        private double maxA, maxB;
        private boolean axMax;

        public double getMaxA() {
            return maxA;
        }

        public double getMaxB() {
            return maxB;
        }
        boolean isAxMax() {
            return axMax;
        }
    }

    public double getExtremum(Function function, double startPoint, double endPoint, ExtremaType extremaType, double e) {
        double a = startPoint;
        double b = endPoint;
        int iteration = 0;
        do{
            iteration++;
            double x = getX(a, b);
            ComparePointResult bigVector = comparePoint(function,a, b, x);
            double s = getRandom(bigVector.getMaxA(),bigVector.getMaxB());
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

        }while ((b - a) > e) ;
        printLog(iteration, "END",a,b, 0, 0);
        return (a+b)/2;
    }

    private void printLog(int iteration, String s, double a, double b, double x, double v) {
        System.out.printf(iteration+",\t"+s+" ,\ta=%.4f,\tb=%.4f,\tx=%.4f,\ts=%.4f\n",a,b,x,v);
    }

    private double getX(double startPoint, double endPoint) {
        return getRandom(startPoint,endPoint);
//        return startPoint+(endPoint-startPoint)/2;
    }

    private double getRandom(double a, double b) {
        return a + RANDOM.nextDouble()*(b-a);
    }

    private ComparePointResult comparePoint(Function function, double a, double b, double x) {
        double moduleAX = getModuleVector(a, x);
        double moduleXB = getModuleVector(x, b);
        if (moduleAX < moduleXB) {
            return new ComparePointResult(a, x,true);
        }
        return new ComparePointResult(x, b,false);
    }

    double getModuleVector(double x1, double x2) {
        return Math.abs(x1 - x2);
    }
}
