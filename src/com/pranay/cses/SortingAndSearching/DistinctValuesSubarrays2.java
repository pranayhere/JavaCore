//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integers, your task is to calculate the number of subarrays that have at most k distinct values.
 * Input
 * The first input line has two integers n and k.
 * The next line has n integers x_1,x_2,\dots,x_n: the contents of the array.
 * Output
 * Print one integer: the number of subarrays.
 * Constraints
 *
 * 1 \le k \le n \le 2 \cdot 10^5
 * 1 \le x_i \le 10^9
 *
 * Example
 * Input:
 * 5 2
 * 1 2 3 1 1
 *
 * Output:
 * 10
 */
public class DistinctValuesSubarrays2 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }

        int lo = 0;
        long cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int hi = 0; hi < n; hi++) {
            hm.put(nums[hi], hm.getOrDefault(nums[hi], 0) + 1);

            while (hm.size() > k) {
                int rm = nums[lo++];
                hm.put(rm, hm.get(rm) - 1);
                if (hm.get(rm) == 0) {
                    hm.remove(rm);
                }
            }

            cnt += hi - lo + 1;
        }

        System.out.println(cnt) ;
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
