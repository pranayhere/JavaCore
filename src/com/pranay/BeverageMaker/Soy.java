package com.pranay.BeverageMaker;

public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
//        System.out.println("Soy cost");
        return .15 + beverage.cost();
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", Soy";
    }
}
