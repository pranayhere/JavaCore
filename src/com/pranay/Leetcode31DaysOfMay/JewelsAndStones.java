package com.pranay.Leetcode31DaysOfMay;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int count = numJewelsInStones(J, S);
        System.out.println("Count : " + count);
    }

    private static int numJewelsInStones(String j, String s) {
        int count = 0;
        Set<Character> jewels = new HashSet<>();
        for(char ch : j.toCharArray()) {
            jewels.add(ch);
        }

        for (char ch : s.toCharArray()) {
            if (jewels.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}