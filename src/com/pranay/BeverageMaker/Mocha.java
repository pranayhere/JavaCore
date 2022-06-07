package com.pranay.BeverageMaker;

public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
//        System.out.println("Mocha cost");
        return .20 + beverage.cost();
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", Mocha";
    }
}
