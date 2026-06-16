//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of n positive integers, your task is to count the number of subarrays having sum x.
Input
The first input line has two integers n and x: the size of the array and the target sum x.
The next line has n integers a_1,a_2,\dots,a_n: the contents of the array.
Output
Print one integer: the required number of subarrays.
Constraints

1 \le n \le 2 \cdot 10^5
1 \le x,a_i \le 10^9

Example
Input:
5 7
2 4 1 2 7

Output:
3
 */
public class SubarraySum1 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int x = fs.nextInt();

        Map<Long, Long> hm = new HashMap<>();
        hm.put(0L, 1L);

        long sum = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            long curr = fs.nextInt();

            sum += curr;
            if (hm.containsKey(sum - x)) {
                count += hm.get(sum - x);
            }

            hm.put(sum, hm.getOrDefault(sum, 0L) + 1);
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
