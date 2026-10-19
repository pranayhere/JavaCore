package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://cses.fi/problemset/task/1630
 *
 * Tasks and Deadlines
 *
 * You have to process n tasks. Each task has a duration and a deadline, and
 * you will process the tasks in some order one after another. Your reward for
 * a task is d - f where d is its deadline and f is your finishing time. (The
 * starting time is 0, and you have to process all tasks even if a task would
 * yield negative reward.)
 *
 * What is your maximum reward if you act optimally?
 *
 * Input
 * The first input line has an integer n: the number of tasks.
 * After this, there are n lines that describe the tasks. Each line has two
 * integers a and d: the duration and deadline of the task.
 *
 * Output
 * Print one integer: the maximum reward.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= a, d <= 10^6
 *
 * Example
 * Input:
 * 3
 * 6 10
 * 8 15
 * 5 12
 *
 * Output:
 * 2
 */

/**
 * Solution: process the tasks shortest first
 *
 * ------------------------------------------------------------
 *
 * STEP 1: split the reward
 *
 *   total reward = sum(d_i - f_i) = sum(d_i) - sum(f_i)
 *
 * sum(d_i) is the same in every order, so maximizing the reward is the same
 * as minimizing the sum of finishing times. Deadlines don't affect the order.
 *
 * ------------------------------------------------------------
 *
 * STEP 2: what sum(f_i) depends on
 *
 * Running durations a1, a2, ..., an in that order:
 *
 *   f1 = a1
 *   f2 = a1 + a2
 *   f3 = a1 + a2 + a3
 *   ...
 *
 *   sum(f) = n*a1 + (n-1)*a2 + ... + 1*an
 *
 * Earlier positions get bigger multipliers, so put the smallest durations
 * first.
 *
 * ------------------------------------------------------------
 *
 * STEP 3: swapping two neighbours
 *
 * Two adjacent tasks with durations x > y, starting at time s:
 *
 *   | Order       | Finish times      | Sum           |
 *   |-------------|-------------------|---------------|
 *   | x then y    | s + x, s + x + y  | 2s + 2x + y   |
 *   | y then x    | s + y, s + x + y  | 2s + x + 2y   |
 *
 * Putting the shorter one first lowers the sum by x - y > 0, and no other
 * finishing time changes. Keep swapping until it's sorted by duration, so
 * sorted order is the best.
 *
 * ------------------------------------------------------------
 *
 * ON THE SAMPLE
 *
 * Durations 6, 8, 5; deadlines sum to 10 + 15 + 12 = 37.
 * Shortest first (5, 6, 8): finish times 5, 11, 19, sum = 35.
 * reward = 37 - 35 = 2.
 *
 * ------------------------------------------------------------
 *
 * NOTES
 *
 * - Tie-break on deadline is not needed: equal durations give the same total
 *   in either order.
 * - Use long for time and reward: n = 2*10^5 tasks of 10^6 each make the
 *   reward about -2*10^16.
 *
 * TIME COMPLEXITY: O(n log n) for the sort.
 *
 * TL;DR: the sum of the deadlines, is the same in every order. So maximizing
 * the reward is the same as minimizing the sum of finishing times.
 */
public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        List<int[]> tasks = new ArrayList<>();
        while (n-- > 0) {
            int duration = fs.nextInt();
            int ddl = fs.nextInt();

            tasks.add(new int[]{duration, ddl});
        }

        Collections.sort(tasks, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        long time = 0;
        long rwd = 0;

        for (int[] task: tasks) {
            int dur = task[0];
            int ddl = task[1];

            time += dur;
            rwd += ddl - time;
        }

        System.out.println(rwd);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
}
