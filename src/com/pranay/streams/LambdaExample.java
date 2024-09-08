package com.pranay.streams;

public class LambdaExample {
    public static void main(String[] args) {

        MyFunction myFunction = (name) -> System.out.println("Hello " + name);
        myFunction.apply("Pranay");
        System.out.println(myFunction.apply1());
    }
}

interface MyFunction {
    public void apply(String name);
    default String apply1() {
        return "Default method";
    }
}
