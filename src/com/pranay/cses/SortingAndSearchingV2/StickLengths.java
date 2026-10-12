package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * https://cses.fi/problemset/task/1074
 *
 * Stick Lengths
 *
 * There are n sticks with some lengths. Your task is to modify the sticks so
 * that each stick has the same length.
 *
 * You can either lengthen and shorten each stick. Both operations cost x where
 * x is the difference between the new and original length.
 *
 * What is the minimum total cost?
 *
 * Input
 * The first input line contains an integer n: the number of sticks.
 * Then there are n integers: p1, p2, ..., pn: the lengths of the sticks.
 *
 * Output
 * Print one integer: the minimum total cost.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= pi <= 10^9
 *
 * Example
 * Input:
 * 5
 * 2 3 1 5 2
 *
 * Output:
 * 5
 */
public class StickLengths {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextLong();
        }

        Arrays.sort(arr);
        long median = arr[n / 2];

        long ans = 0;
        for (long x : arr) {
            ans += Math.abs(x - median);
        }

        System.out.println(ans);
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
