package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CanMakePaliQueries {
    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> ans = canMakePaliQueries(s, queries);
        System.out.println(ans);
    }

    private static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int k = query[2];

            String substr = s.substring(start, end+1);

            boolean check = canFormPalindrom(substr, k);
            System.out.println("is palindrom : " +check);
        }
        return null;
    }

    private static boolean canFormPalindrom(String substr, int k) {
        System.out.println(substr + " - "+ k);
        String[] str = substr.split("");

        Map<String, Integer> hm = new HashMap<>();
        for (String ch: str) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        AtomicReference<Integer> ones = new AtomicReference<>(0);
        hm.forEach((key, v) -> {
            if (v==1) ones.getAndSet(ones.get() + 1);
        });
        System.out.println("printing ones : " +ones);
        if (str.length % 2 == 0) {
            //even
            if (ones.get() <= k)
                return true;
        } else {
            //odd
            if (ones.get() <= k+1)
                return true;
        }
        return false;
    }
}

