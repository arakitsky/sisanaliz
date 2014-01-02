package com.bstu.sisanaliz.lab5;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 02.01.14
 * Time: 3:47
 * To change this template use File | Settings | File Templates.
 */
public class QueryBuilderHelper {
    public static final double x01 = 19;
    public static final double x02 = 20;

    public static final double a11 = 0.9;
    public static final double a12 = -0.45;
    public static final double a21 = -0.42;
    public static final double a22 = 1;

    public static final double b1 = 3;
    public static final double b2 = 2;

    public static final double xn11 = 2;
    public static final double xn12 = 14;

    public static final double xn21 = 4;
    public static final double xn22 = 17;

    public static final double v0 = 0;
    public static final double v1 = 2;

    public static final int N = 8;
    public static final String MAIN_STRING = "Maximize[x" + N + "1, {x01 == " + x01 + ", x02 == " + x02 + ",\n" +
            "  %s" +
            "  %s\n" +
            "  x" + N + "1 >= " + xn11 + ", x" + N + "1 <= " + xn21 + ",\n" +
            "  x" + N + "2 >= " + xn12 + ", x" + N + "2 <= " + xn22 + "},\n" +
            " {%s,x" + N + "1,x" + N + "2}]";


    public static void main(String[] args) {
        StringBuilder xSB = new StringBuilder();
        StringBuilder vSB1=new StringBuilder();
        StringBuilder vSB2=new StringBuilder();
        StringBuilder vi=new StringBuilder();
        StringBuilder xi=new StringBuilder("x01,x02,");
        for (int i = 1; i < N; i++) {
            xSB.append("x"+i+"1==(" + a11 + ")x"+(i-1)+"1+(" + a12 + ")x"+(i-1)+"2+(" + b1 + ")v"+(i-1)+",x"+i+"2==(" + a21 + ")x"+(i-1)+"1+(" + a22 + ")x"+(i-1)+"2+(" + b2 + ")v"+(i-1)+",\n  ");
            vSB1.append("v"+(i-1)+">="+v0+",");
            vSB2.append("v"+(i-1)+"<="+v1+",");
            vi.append("v"+(i-1)+",");
            xi.append("x"+i+"1,"+"x"+i+"2,");
        }
        String vAndX = vi.toString() + xi.toString();
        System.out.printf(MAIN_STRING, xSB.toString(), vSB1.toString()+"\n"+vSB2.toString(), vAndX.substring(0,vAndX.length()-1));
    }
}
