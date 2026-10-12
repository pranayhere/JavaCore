package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

/**
 * https://cses.fi/problemset/task/1629
 *
 * Movie Festival
 *
 * In a movie festival n movies will be shown. You know the starting and ending
 * time of each movie. What is the maximum number of movies you can watch
 * entirely?
 *
 * Input
 * The first input line has an integer n: the number of movies.
 * After this, there are n lines that describe the movies. Each line has two
 * integers a and b: the starting and ending times of a movie.
 *
 * Output
 * Print one integer: the maximum number of movies.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= a < b <= 10^9
 *
 * Example
 * Input:
 * 3
 * 3 5
 * 4 9
 * 5 8
 *
 * Output:
 * 2
 */
public class MovieFestival {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int start = fs.nextInt();
            int end = fs.nextInt();

            pq.offer(new int[]{start, end});
        }

        int count = 0;
        int lastEnd = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] >= lastEnd) {
                count++;
                lastEnd = curr[1];
            }
        }

        System.out.println(count);
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
