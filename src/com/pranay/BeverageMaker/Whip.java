package com.pranay.BeverageMaker;

public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
//        System.out.println("Whip cost");
        return .10 + beverage.cost();
    }

    public String getDesc() {
        return beverage.getDesc() + ", Whip";
    }
}
