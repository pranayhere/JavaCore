package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * https://cses.fi/problemset/task/2216
 *
 * Collecting Numbers
 *
 * You are given an array that contains each number between 1 ... n exactly
 * once. Your task is to collect the numbers from 1 to n in increasing order.
 *
 * On each round, you go through the array from left to right and collect as
 * many numbers as possible. What will be the total number of rounds?
 *
 * Input
 * The first line has an integer n: the array size.
 * The next line has n integers x1, x2, ..., xn: the numbers in the array.
 *
 * Output
 * Print one integer: the number of rounds.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 *
 * Example
 * Input:
 * 5
 * 4 2 1 5 3
 *
 * Output:
 * 3
 */
public class CollectingNumbers {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        boolean[] seen = new boolean[n + 1];   // seen[0] stays false, so 1 always starts a round
        int rounds = 0;

        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            if (!seen[num - 1]) {
                rounds++;                       // num - 1 comes later, so num needs a new round
            }
            seen[num] = true;
        }

        System.out.println(rounds);
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
