package com.bstu.sisanaliz;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 28.12.13
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
public interface MultivariateFunction extends Function {
    Point getAntiGradient(Point point);
}
