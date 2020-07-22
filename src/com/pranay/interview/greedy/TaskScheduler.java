package com.pranay.interview.greedy;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int time = leastInterval(tasks, n);
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
}
