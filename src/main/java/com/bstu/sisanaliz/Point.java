package com.bstu.sisanaliz;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 27.12.13
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    double[] value;

    public double[] getValue() {
        return value;
    }

    public Point(double[] value) {
        this.value = value;
    }

    public Point minus(Point point) {
        double[] value2 = point.getValue();
        if (value2.length != value.length) {
            throw new IllegalArgumentException("Неверные размеры");
        }
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] - value2[i];
        }
        return new Point(result);
    }

    public Point plus(Point point) {
        double[] value2 = point.getValue();
        if (value2.length != value.length) {
            throw new IllegalArgumentException("Неверные размеры");
        }
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] + value2[i];
        }
        return new Point(result);
    }

    public Point multiply(double number) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] * number;
        }
        return new Point(result);
    }

    public boolean more(Point point) {
        double[] value2 = point.getValue();
        if (value2.length != value.length) {
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            double v1 = value[i];
            double v2 = value2[i];
            if (v1 < v2) {
                return false;
            }
        }
        return true;
    }

    public double module() {
        double result = 0;
        for (int i = 0; i < value.length; i++) {
            result += Math.pow(value[i], 2);
        }
        return Math.sqrt(result);
    }

    public boolean equals(Point point, double e) {
        double[] value2 = point.getValue();
        if (value2.length != value.length) {
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            double v1 = value[i];
            double v2 = value2[i];
            if (Math.abs(v1 - v2) > e) {
                return false;
            }
        }
        return true;
    }

    public static Point createPint(double... doubles) {
        return new Point(doubles);

    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
