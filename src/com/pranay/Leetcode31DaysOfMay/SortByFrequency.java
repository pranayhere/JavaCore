package com.pranay.Leetcode31DaysOfMay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Bucket Sort correct impl

public class SortByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String ans = frequencySort(s);
        System.out.println("Ans : " + ans);
    }

    private static String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> counts = new HashMap<>();
        for (char ch: s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        int maximumFrequency = Collections.max(counts.values());
        List<List<Character>> buckets = new ArrayList<>();

        for (int i = 0; i<=maximumFrequency; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Character key: counts.keySet()) {
            int freq = counts.get(key);
            buckets.get(freq).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
