package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://cses.fi/problemset/task/1091
 *
 * Concert Tickets
 *
 * There are n concert tickets available, each with a certain price. Then, m
 * customers arrive, one after another.
 *
 * Each customer announces the maximum price they are willing to pay for a
 * ticket, and after this, they will get a ticket with the nearest possible
 * price such that it does not exceed the maximum price.
 *
 * Input
 * The first input line contains integers n and m: the number of tickets and
 * the number of customers.
 * The next line contains n integers h1, h2, ..., hn: the price of each ticket.
 * The last line contains m integers t1, t2, ..., tm: the maximum price for each
 * customer in the order they arrive.
 *
 * Output
 * Print, for each customer, the price that they will pay for their ticket.
 * After this, the ticket cannot be purchased again.
 * If a customer cannot get any ticket, print -1.
 *
 * Constraints
 * - 1 <= n, m <= 2 * 10^5
 * - 1 <= hi, ti <= 10^9
 *
 * Example
 * Input:
 * 5 3
 * 5 3 7 8 5
 * 4 8 3
 *
 * Output:
 * 3
 * 8
 * -1
 */
public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        solveUnionFind(fs);
        // solveTreeMap(fs);
    }

    // Sorted prices + "nearest unsold ticket to the left" (union-find).
    // left[i] == i: ticket i unsold; once sold, left[i] = i - 1 so lookups skip it.
    static void solveUnionFind(FastScanner fs) throws IOException {
        StringBuilder ans = new StringBuilder();
        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = fs.nextInt();
        }
        Arrays.sort(h);

        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int t = fs.nextInt();
            int idx = upperBound(h, t) - 1;
            int j = idx < 0 ? -1 : find(left, idx);
            if (j < 0) {
                ans.append(-1).append('\n');
            } else {
                ans.append(h[j]).append('\n');
                left[j] = j - 1;
            }
        }

        System.out.print(ans);
    }

    // first index with a[i] > key
    static int upperBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // largest unsold index <= i, or -1
    static int find(int[] left, int i) {
        while (i >= 0 && left[i] != i) {
            if (left[i] >= 0) {
                left[i] = left[left[i]];
            }
            i = left[i];
        }
        return i;
    }

    static void solveTreeMap(FastScanner fs) throws IOException {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        StringBuilder ans = new StringBuilder();
        int n = fs.nextInt();
        int m = fs.nextInt();

        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int x = fs.nextInt();
            Integer floor = tm.floorKey(x);
            if (floor != null) {
                int cnt = tm.get(floor);
                if (cnt == 1) {
                    tm.remove(floor);
                } else {
                    tm.put(floor, cnt - 1);
                }
                ans.append(floor).append("\n");
            } else {
                ans.append(-1).append('\n');
            }
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
