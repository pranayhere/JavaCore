//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * You are given n cubes in a certain order, and your task is to build towers using them. Whenever
 * two cubes are one on top of the other, the upper cube must be smaller than the lower cube.
 * You must process the cubes in the given order. You can always either place the cube on top of an existing tower,
 * or begin a new tower. What is the minimum possible number of towers?
 *
 * Input
 * The first input line contains an integer n: the number of cubes.
 * The next line contains n integers k_1,k_2,...,k_n: the sizes of the cubes.
 *
 * Output
 * Print one integer: the minimum number of towers.
 * Constraints
 *
 * 1 <= n <= 10^5
 * 1 <= k_i <= 10^9
 *
 * Example
 * Input:
 * 5
 * 3 8 2 1 5
 *
 * Output:
 * 2
 */
public class Towers {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();

            Integer ceil = tm.ceilingKey(num + 1);
            if (ceil != null) {
                int cnt = tm.get(ceil);
                if (cnt == 1)
                    tm.remove(ceil);
                else
                    tm.put(ceil, cnt - 1);
            }

            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int key: tm.keySet()) {
            ans += tm.get(key);
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
