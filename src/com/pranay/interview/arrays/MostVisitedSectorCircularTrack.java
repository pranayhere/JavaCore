package com.pranay.interview.arrays;

/**
 * 1560. Most Visited Sector in a Circular Track
 * https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MostVisitedSectorCircularTrack {
    public static void main(String[] args) {
//        int n = 4;
//        int[] rounds = {1,3,1,2};

//        int n = 2;
//        int[] rounds = {2,1,2,1,2,1,2,1,2};

        int n = 7;
        int[] rounds = {1,3,5,7};

        List<Integer> ans = mostVisited(n, rounds);
        System.out.println(ans);
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < rounds.length - 1; i++) {
            int start = i == 0 ? rounds[i] : rounds[i] + 1;
            int end = rounds[i + 1];
            if (end < start)
                end += n;

            for (int j = start; j <= end; j++) {
                int visited = j;
                if (j / n >= 1 && j % n > 0)
                    visited = j % (n + 1) + 1;
                else
                    visited = (j % (n + 1));
                hm.put(visited, hm.getOrDefault(visited, 0) + 1);
            }
        }

        System.out.println(hm);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int k: hm.keySet()) {
            pq.offer(new int[]{k, hm.get(k)});
        }

        System.out.println(pq);

        List<Integer> ans = new ArrayList<>();
        int[] first = pq.poll();
        int max = first[1];
        ans.add(first[0]);

        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            if (peek[1] == max)
                ans.add(peek[0]);
        }

        return ans;
    }
}
