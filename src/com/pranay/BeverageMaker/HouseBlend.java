package com.pranay.BeverageMaker;

public class HouseBlend extends Beverage {
    @Override
    public String getDesc() {
        return "HouseBlend";
    }

    public double cost() {
//        System.out.println("HouseBlend cost");
        return .89;
    }
}
