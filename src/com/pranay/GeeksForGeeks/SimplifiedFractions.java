package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplifiedFractions {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = simplifiedFractions(n);
        System.out.println(ans);
        System.out.println( (double)1/ (double)2);
    }

    private static List<String> simplifiedFractions(int n) {
        Set<Double> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                double fraction = (double)j / (double)i;
                if (fraction == 1 || set.contains(fraction)) {
                    continue;
                } else {
                    set.add(fraction);
                    String str = j + "/" + i;
                    list.add(str);
                }
            }
        }
        return list;
    }
}