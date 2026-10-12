package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://cses.fi/problemset/task/2217
 *
 * Collecting Numbers II
 *
 * You are given an array that contains each number between 1 ... n exactly
 * once. Your task is to collect the numbers from 1 to n in increasing order.
 *
 * On each round, you go through the array from left to right and collect as
 * many numbers as possible.
 *
 * Given m operations that swap two numbers in the array, your task is to
 * report the number of rounds after each operation.
 *
 * Input
 * The first line has two integers n and m: the array size and the number of
 * operations.
 * The next line has n integers x1, x2, ..., xn: the numbers in the array.
 * Finally, there are m lines that describe the operations. Each line has two
 * integers a and b: the numbers at positions a and b are swapped.
 *
 * Output
 * Print m integers: the number of rounds after each swap.
 *
 * Constraints
 * - 1 <= n, m <= 2 * 10^5
 * - 1 <= a, b <= n
 *
 * Example
 * Input:
 * 5 3
 * 4 2 1 5 3
 * 2 3
 * 1 5
 * 2 3
 *
 * Output:
 * 2
 * 3
 * 4
 */
public class CollectingNumbersII {
    static int[] pos;

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] arr = new int[n + 1];
        pos = new int[n + 2];
        pos[0] = 0;          // sentinels: pairs (0, 1) and (n, n+1) never count as breaks
        pos[n + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = fs.nextInt();
            pos[arr[i]] = i;
        }

        int breaks = 0;
        for (int x = 1; x < n; x++) {
            breaks += isBreak(x);
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < m; q++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int u = arr[a], v = arr[b];

            // only pairs touching u or v can change; the set removes duplicates
            Set<Integer> pairs = new HashSet<>(List.of(u - 1, u, v - 1, v));

            for (int x : pairs) breaks -= isBreak(x);
            arr[a] = v;
            arr[b] = u;
            pos[u] = b;
            pos[v] = a;
            for (int x : pairs) breaks += isBreak(x);

            sb.append(breaks + 1).append('\n');
        }

        System.out.print(sb);
    }

    // 1 if x+1 comes before x, i.e. collecting x+1 needs a new round
    static int isBreak(int x) {
        return pos[x + 1] < pos[x] ? 1 : 0;
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
