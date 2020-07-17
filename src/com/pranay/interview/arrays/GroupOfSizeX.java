package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class GroupOfSizeX {
    public static void main(String[] args) {
        int[] deck = {1,2,3,4,4,3,2,1};
        boolean ans = hasGroupsSizeX(deck);
        System.out.println("Ans : " + ans);
    }

    private static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int d: deck)
            count.put(d, count.getOrDefault(d, 0) + 1);

        for (int i: count.keySet())
            res = gcd(i, res);

        return res > 1;
    }

    private static int gcd(int a, int b) {
        return b > a ? gcd (b, a % b) : a;
    }
}
