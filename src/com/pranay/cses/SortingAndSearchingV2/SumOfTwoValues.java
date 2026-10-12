package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * https://cses.fi/problemset/task/1640
 *
 * Sum of Two Values
 *
 * You are given an array of n integers, and your task is to find two values
 * (at distinct positions) whose sum is x.
 *
 * Input
 * The first input line has two integers n and x: the array size and the target
 * sum.
 * The second line has n integers a1, a2, ..., an: the array values.
 *
 * Output
 * Print two integers: the positions of the values. If there are several
 * solutions, you may print any of them. If there are no solutions, print
 * IMPOSSIBLE.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= x, ai <= 10^9
 *
 * Example
 * Input:
 * 4 8
 * 2 7 5 1
 *
 * Output:
 * 2 4
 */
public class SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int k = fs.nextInt();

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            if (hm.containsKey(k - num)) {
                System.out.println(hm.get(k - num) + 1 + " " + (i + 1));
                return;
            }

            hm.put(num, i);
        }

        System.out.print("IMPOSSIBLE");
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
