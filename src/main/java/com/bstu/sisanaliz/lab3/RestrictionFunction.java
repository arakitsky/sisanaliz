package com.bstu.sisanaliz.lab3;

import com.bstu.sisanaliz.AbstractFunction;
import com.bstu.sisanaliz.Function;
import com.bstu.sisanaliz.MultivariateFunction;
import com.bstu.sisanaliz.Point;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 777
 * Date: 31.12.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
public abstract class RestrictionFunction extends AbstractFunction implements MultivariateFunction {

    private int tau = 1;

    private List<Restriction> restrictionList;

    protected RestrictionFunction(List<Restriction> restrictionList) {
        this.restrictionList = restrictionList;
    }

    public void incrementTau(){
        tau*=2;
    }

    public int getTau() {
        return tau;
    }

    protected List<Restriction> getRestrictionList() {
        return restrictionList;
    }
}
