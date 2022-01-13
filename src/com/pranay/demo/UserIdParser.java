package com.pranay.demo;

import java.util.ArrayList;
import java.util.List;

public class UserIdParser {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add(null);
        names.add("b");

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(null);
        nums.add(2);

        System.out.println(names);
        System.out.println(nums);

        System.out.println(names.remove(1));
        System.out.println(nums.remove(1));

        System.out.println(names);
        System.out.println(nums);
    }
}
