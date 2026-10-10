package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * https://cses.fi/problemset/task/1090
 *
 * Ferris Wheel
 *
 * There are n children who want to go to a Ferris wheel, and your task is to
 * find a gondola for each child.
 *
 * Each gondola may have one or two children in it, and in addition, the total
 * weight in a gondola may not exceed x. You know the weight of every child.
 *
 * What is the minimum number of gondolas needed for the children?
 *
 * Input
 * The first input line contains two integers n and x: the number of children
 * and the maximum allowed weight.
 * The next line contains n integers p1, p2, ..., pn: the weight of each child.
 *
 * Output
 * Print one integer: the minimum number of gondolas.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= x <= 10^9
 * - 1 <= pi <= x
 *
 * Example
 * Input:
 * 4 10
 * 7 2 3 9
 *
 * Output:
 * 3
 */

// 2, 4, 6, 8
public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int x = fs.nextInt();

        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = fs.nextInt();
        }

        Arrays.sort(wt);
        int lo = 0;
        int hi = n - 1;
        int gandolas = 0;

        while (lo <= hi) {
            if (wt[hi] + wt[lo] <= x) {
                hi--;
                lo++;
                gandolas++;
            } else {
                hi--;
                gandolas++;
            }
        }

        System.out.println(gandolas);
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
