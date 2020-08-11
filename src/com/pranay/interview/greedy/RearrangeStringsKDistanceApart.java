package com.pranay.interview.greedy;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringsKDistanceApart {
    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 3;

        String ans = rearrangeString(s, k);
        System.out.println("Ans : " + ans);
    }

    private static String rearrangeString(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        for (char ch: s.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char ch: count.keySet())
            pq.offer(new int[] {ch, count.get(ch)});


        String ans = "";
        Queue<int[]> waitQ = new ArrayDeque<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans += (char) curr[0];
            curr[1]--;
            waitQ.offer(curr);

            if (waitQ.size() < k)
                continue;

            int[] front = waitQ.poll();
            if (front[1] > 0)
                pq.offer(front);
        }

        return ans.length() == s.length() ? ans : "";
    }
}
