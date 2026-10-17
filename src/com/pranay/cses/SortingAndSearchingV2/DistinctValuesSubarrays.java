package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * https://cses.fi/problemset/task/3420
 *
 * Distinct Values Subarrays
 *
 * Given an array of n integers, count the number of subarrays where each
 * element is distinct.
 *
 * Input
 * The first line has an integer n: the array size.
 * The second line has n integers x1, x2, ..., xn: the array contents.
 *
 * Output
 * Print the number of subarrays with distinct elements.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= xi <= 10^9
 *
 * Example
 * Input:
 * 4
 * 1 2 1 3
 *
 * Output:
 * 8
 *
 * Explanation: The subarrays are [1] (two times), [2], [3], [1,2], [1,3],
 * [2,1] and [2,1,3].
 */
public class DistinctValuesSubarrays {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] arr = new int[n];
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            arr[i] = num;
        }

        int lo = 0;
        long ans = 0;
        for (int hi = 0; hi < n; hi++) {
            while (hs.contains(arr[hi])) {
                hs.remove(arr[lo++]);
            }

            hs.add(arr[hi]);
            ans += hs.size();
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
