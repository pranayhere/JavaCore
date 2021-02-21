package com.pranay.interview.arrays;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        String s = "YazaAay";
        String ans = longestNiceSubstring(s);
        System.out.println("Ans : " + ans);
    }

    private static String longestNiceSubstring(String s) {
        int maxLen = -1;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
//                System.out.println(str);
                if (str.length() > maxLen && check(str)) {
                    ans = str;
                    maxLen = str.length();
                }
            }
        }
        return ans;
    }

    private static boolean check(String str) {
        Set<Integer> lower = new HashSet<>();
        Set<Integer> upper = new HashSet<>();

        for (char ch: str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch - 'A');
            } else {
                lower.add(ch - 'a');
            }
        }

        return lower.equals(upper);
    }
}
