package com.pranay.BeverageMaker;

public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
//        System.out.println("Milk cost");
        return .10 + beverage.cost();
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", Milk";
    }
}
