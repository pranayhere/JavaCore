package com.pranay.interview.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 * #trick
 */

public class StringIsomorphic {
    public static void main(String[] args) {
        String s = "abcabc", t = "pqrpqr";
        boolean ans =  isIsomorphic(s, t);
        System.out.println("Ans : " + ans);
    }

    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (Integer i = 0; i < s.length(); i++) {
            Integer fir = m1.put(s.charAt(i), i);
            Integer sec = m2.put(t.charAt(i), i);

            if (fir != sec)
                return false;
        }
        return true;
    }
}
