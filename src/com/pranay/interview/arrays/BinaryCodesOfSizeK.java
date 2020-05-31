package com.pranay.interview.arrays;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

import java.util.HashSet;
import java.util.Set;

public class BinaryCodesOfSizeK {
    public static void main(String[] args) {
        String s = "00110";
        int k = 2;
        boolean ans = hasAllCodes(s, k);
        System.out.println("Ans : " + ans);
    }

    private static boolean hasAllCodes(String s, int k) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i<=s.length(); i++) {
            if (i < k) {
                continue;
            }
            String substr = s.substring(i-k, i);
            hs.add(substr);
        }
        System.out.println(hs);
        return hs.size() == Math.pow(2, k);
    }

}
