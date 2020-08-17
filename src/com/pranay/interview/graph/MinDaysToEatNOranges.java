package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinDaysToEatNOranges {
    public static void main(String[] args) {
        int n = 56;
        MinDaysToEatNOranges mdeo = new MinDaysToEatNOranges();
        int days = mdeo.minDaysBFS(n);
        System.out.println("Min Days : " + days);
    }

    public int minDaysBFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        int days = 0;
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            days++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == 0)
                    return days - 1;

                if (set.contains(cur))
                    continue;
                else
                    set.add(cur);

                if (cur % 3 == 0)
                    q.offer(cur / 3);

                if (cur % 2 == 0)
                    q.offer(cur / 2);

                q.offer(cur - 1);
            }
        }

        return days;
    }



    public int minDays(int n) {
        Integer[] day = new Integer[1];
        day[0] = 0;
        dfs(n, day);
        return minDay;
    }

    int minDay = Integer.MAX_VALUE;

    public void dfs(int n, Integer[] day) {
        if (n < 0)
            return;

        if (n == 0) {
            minDay = Math.min(day[0], minDay);
            return;
        }

        day[0]++;
        if (n % 2 == 0) {
            dfs (n / 2, day);
        }

        if (n % 3 == 0) {
            dfs (n / 3, day);
        }


        dfs(n - 1, day);
    }
}
