package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * https://cses.fi/problemset/task/1621
 *
 * Distinct Numbers
 *
 * You are given a list of n integers, and your task is to calculate the number
 * of distinct values in the list.
 *
 * Input
 * The first input line has an integer n: the number of values.
 * The second line has n integers x1, x2, ..., xn.
 *
 * Output
 * Print one integer: the number of distinct values.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= xi <= 10^9
 *
 * Example
 * Input:
 * 5
 * 2 3 2 2 3
 *
 * Output:
 * 2
 */

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }

        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != prev) {
                count++;
                prev = nums[i];
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
