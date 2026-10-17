package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://cses.fi/problemset/task/2162
 *
 * Josephus Problem I
 *
 * Consider a game where there are n children (numbered 1, 2, ..., n) in a
 * circle. During the game, every other child is removed from the circle until
 * there are no children left. In which order will the children be removed?
 *
 * Input
 * The only input line has an integer n.
 *
 * Output
 * Print n integers: the removal order.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 *
 * Example
 * Input:
 * 7
 *
 * Output:
 * 2 4 6 1 5 3 7
 */
public class JosephusProblemI {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = fs.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            q.add(q.poll());
            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb.toString().trim());
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
