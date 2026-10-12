package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;

/**
 * https://cses.fi/problemset/task/1643
 *
 * Maximum Subarray Sum
 *
 * Given an array of n integers, your task is to find the maximum sum of values
 * in a contiguous, nonempty subarray.
 *
 * Input
 * The first input line has an integer n: the size of the array.
 * The second line has n integers x1, x2, ..., xn: the array values.
 *
 * Output
 * Print one integer: the maximum subarray sum.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - -10^9 <= xi <= 10^9
 *
 * Example
 * Input:
 * 8
 * -1 3 -2 5 3 -5 2 2
 *
 * Output:
 * 9
 */
public class MaximumSubarraySum {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        long currSum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currSum += fs.nextInt();
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }

        System.out.println(maxSum);
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
