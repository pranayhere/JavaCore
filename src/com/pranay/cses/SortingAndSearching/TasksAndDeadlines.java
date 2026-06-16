//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long[][] tasks = new long[n][2];

        for (int i = 0; i < n; i++) {
            long duration = fs.nextLong();
            long deadline = fs.nextLong();

            tasks[i][0] = duration;
            tasks[i][1] = deadline;
        }

        Arrays.sort(tasks, Comparator.comparingLong(a -> a[0]));
        long time = 0L;
        long reward = 0L;

        for (long[] task: tasks) {
            time += task[0];
            reward += task[1] - time;
        }

        System.out.println(reward);
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
