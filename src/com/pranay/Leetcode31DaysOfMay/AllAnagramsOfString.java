package com.pranay.Leetcode31DaysOfMay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllAnagramsOfString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> startPos = findAnagramsArrays(s, p);
        System.out.println("Start position : " + startPos);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();


        for (char ch : p.toCharArray()) {
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        System.out.println("pmap : " + pmap);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (pmap.containsKey(ch)) {
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            }

            if (i >= p.length()) {
                char rm = s.charAt(i - p.length());
                if (smap.containsKey(rm)) {
                    int val = smap.get(rm);
                    val--;
                    if (val == 0) {
                        smap.remove(rm);
                    } else {
                        smap.put(rm, val);
                    }
                }
            }

            if (smap.equals(pmap)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }

    public static List<Integer> findAnagramsArrays(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ns = s.length();
        int np = p.length();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        if (ns < np) {
            return res;
        }

        for (char ch: p.toCharArray()) {
            pCount[(int) ch - 'a']++;
        }

        for (int i = 0; i<s.length(); i++) {
            sCount[(int) s.charAt(i) - 'a']++;

            if (i >= np) {
                sCount[(int) s.charAt(i - np) - 'a']--;
            }

            System.out.println(Arrays.toString(sCount));
            System.out.println(Arrays.toString(pCount));
            System.out.println("----------------------");
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - np + 1);
            }
        }
        return res;
    }
}
