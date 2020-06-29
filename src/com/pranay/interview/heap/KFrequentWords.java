package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;

        List<String> ans = topKFrequent(words, k);
        System.out.println("Ans : " + ans);
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) ->
                count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2)
        );

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty())
            ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
