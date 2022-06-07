package com.pranay.BeverageMaker;

public class CoffeeMaker {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDesc() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDesc() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDesc() + " $" + beverage3.cost());
    }
}
