package com.pranay.BeverageMaker;

public class Espresso extends Beverage{
    public Espresso() {
        desc = "Espresso";
    }

    @Override
    public double cost() {
//        System.out.println("Espresso cost");
        return 1.99;
    }
}
