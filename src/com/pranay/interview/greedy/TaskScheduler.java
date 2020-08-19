package com.pranay.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public static void main(String[] args) {
//        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'}; // ans = 16
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int time = leastInterval2(tasks, n);
        System.out.println("Time : " + time);
    }

    private static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int t: tasks)
            freq[t - 'A']++;

        Arrays.sort(freq);

        int fMax = freq[25];
        int idealTime = (fMax - 1) * n;

        for (int i = freq.length - 2; i >=0 && idealTime > 0; i++) {
            idealTime -= Math.min(fMax - 1, freq[i]);
        }

        return idealTime + tasks.length;
    }

    // Priority Queue Time: O()
    private static int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for (char ch: tasks)
            count.put(ch, count.getOrDefault(ch, 0) + 1); // O(n)

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // O(n.logn)
        pq.addAll(count.values());

        int allTime = 0;
        int cycle = n + 1;

        while (!pq.isEmpty()) { // O(n * cycle)
            int workTime = 0;
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                    workTime++;
                }
            }

            for (int cnt: tmp) {
                cnt--;
                if (cnt > 0)
                    pq.offer(cnt);
            }

            allTime += !pq.isEmpty() ? cycle : workTime;
        }

        return allTime;
    }
}
