package com.pranay.Leetcode31DaysOfMay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstUniqChar(s);
        System.out.println("Index of first unique : " + index);
    }

    private static int firstUniqChar(String s) {
        Map<Character, Integer> hm = new LinkedHashMap<>(); // contain unique
        Set<Character> hs = new HashSet<>(); // contain non unique

        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                hm.remove(ch);
                hs.add(ch);
            } else if (hs.contains(ch)) {
                continue;
            } else {
                hm.put(ch, i);
            }
        }
        return !hm.isEmpty() ? hm.get(hm.keySet().iterator().next()) : -1;
    }
}
