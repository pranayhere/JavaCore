package com.pranay.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1525. Number of Good Ways to Split a String
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 *
 * keep count of all characters in the given String.
 * Ex : "aacaba"
 * HashMap will look like : {a=4, b=1, c=1}
 *
 * At every stage remove the character from the HashMap and add it to HashSet of left elements
 * left HashMap
 * [a] - {a=3, b=1, c=1}
 * [a] - {a=2, b=1, c=1}
 * [a, c] - {a=2, b=1} - count = 1
 * [a, c] - {a=1, b=1} - count = 2
 * [a, b, c] - {a=1}
 * [a, b, c] - {}
 */
public class GoodWaysToSplitString {
    public static void main(String[] args) {
        String s = "aacaba";
        int count = numSplits(s);
        System.out.println("Count : " + count);
    }

    private static int numSplits(String s) {
        int count = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch: s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        HashSet<Character> left = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                int cnt = hm.get(ch);
                if (cnt == 1) {
                    hm.remove(ch);
                }
                else {
                    hm.put(ch, cnt - 1);
                }

                left.add(ch);
//                System.out.println(left + " - " + hm + " - " + i + "count");
                if (left.size() == hm.size())
                    count++;
            }
        }

        return count;
    }
}
