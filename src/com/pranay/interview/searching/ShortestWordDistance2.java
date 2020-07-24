package com.pranay.interview.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {

    Map<String, List<Integer>> hm;
    public ShortestWordDistance2(String[] words) {
        hm = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            hm.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        System.out.println(hm);
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistance2 swd = new ShortestWordDistance2(words);
        int distance = swd.shortest("coding", "makes");
        System.out.println("Shortest distance : " + distance);
    }

    private int shortest(String w1, String w2) {
        List<Integer> list1 = hm.get(w1);
        List<Integer> list2 = hm.get(w2);

        int l1 = 0, l2 = 0;
        int minDiff = Integer.MAX_VALUE;
        while (l1 < list1.size() && l2 < list2.size()) {
            int diff = Math.abs(list1.get(l1) - list2.get(l2));
            minDiff = Math.min(minDiff, diff);

            if (list1.get(l1) > list2.get(l2))
                l2++;
            else
                l1++;
        }
        return minDiff;
    }
}
