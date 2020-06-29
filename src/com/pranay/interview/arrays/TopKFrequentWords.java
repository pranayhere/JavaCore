package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;

        List<String> ans = topKFrequent(words, k);
        System.out.println("Ans : " + ans);
    }

    private static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> hm = new LinkedHashMap<>();

        for (int i = 0; i<words.length; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }

        int max = Collections.max(hm.values());
        List<List<String>> buckets = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }

        for (String word: hm.keySet()) {
            int freq = hm.get(word);
            buckets.get(freq).add(word);
        }

//        Required for leetcode ans
//        for (int i = 0; i <= max; i++) {
//            Collections.sort(buckets.get(i));
//        }

        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (String str: buckets.get(i)) {
                if (ans.size() >= k) {
                    break;
                }
                ans.add(str);
            }
        }
        return ans;
    }

}