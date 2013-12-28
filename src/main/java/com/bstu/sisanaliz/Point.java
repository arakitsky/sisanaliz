package com.bstu.sisanaliz;

import java.util.Arrays;

public class Point {
    double[] values;

    public double[] getValues() {
        return values;
    }

    public Point(double[] values) {
        this.values = values;
    }

    public Point minus(Point point) {
        double[] value2 = point.getValues();
        if (value2.length != values.length) {
            throw new IllegalArgumentException("Неверные размеры");
        }
        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i] - value2[i];
        }
        return new Point(result);
    }

    public Point plus(Point point) {
        double[] value2 = point.getValues();
        if (value2.length != values.length) {
            throw new IllegalArgumentException("Неверные размеры");
        }
        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i] + value2[i];
        }
        return new Point(result);
    }

    public Point multiply(double number) {
        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i] * number;
        }
        return new Point(result);
    }

    public boolean more(Point point) {
        double[] value2 = point.getValues();
        if (value2.length != values.length) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            double v1 = values[i];
            double v2 = value2[i];
            if (v1 < v2) {
                return false;
            }
        }
        return true;
    }

    public double module() {
        double result = 0;
        for (double value : values) {
            result += Math.pow(value, 2);
        }
        return Math.sqrt(result);
    }

    public boolean equals(Point point, double e) {
        double[] value2 = point.getValues();
        if (value2.length != values.length) {
            System.out.println("Не совпадает длинна точек");
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            double v1 = values[i];
            double v2 = value2[i];
            if (Math.abs(v1 - v2) > e) {
                System.out.println("Точки не равны " + this + ", " + point);
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
                "values=" + Arrays.toString(values) +
                '}';
    }
}
