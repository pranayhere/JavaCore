package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://cses.fi/problemset/task/1073
 *
 * Towers
 *
 * You are given n cubes in a certain order, and your task is to build towers
 * using them. Whenever two cubes are one on top of the other, the upper cube
 * must be smaller than the lower cube.
 *
 * You must process the cubes in the given order. You can always either place
 * the cube on top of an existing tower, or begin a new tower. What is the
 * minimum possible number of towers?
 *
 * Input
 * The first input line contains an integer n: the number of cubes.
 * The next line contains n integers k1, k2, ..., kn: the sizes of the cubes.
 *
 * Output
 * Print one integer: the minimum number of towers.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= ki <= 10^9
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
        solveSortedArray(fs);
        // solveTreeMap(fs);
        // solveTreeSet(fs);
    }

    // Fix 2: tops kept in a sorted array. Placing a cube on the smallest top
    // greater than it keeps the array sorted, so binary search finds that top.
    static void solveSortedArray(FastScanner fs) throws IOException {
        int n = fs.nextInt();
        int[] tops = new int[n];
        int towers = 0;

        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            int idx = upperBound(tops, towers, num);
            if (idx == towers) {
                towers++;           // no top is bigger: start a new tower
            }
            tops[idx] = num;
        }

        System.out.println(towers);
    }

    // first index in a[0..len) with a[i] > key, or len if none
    static int upperBound(int[] a, int len, int key) {
        int lo = 0, hi = len;
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

    // Fix 1: TreeMap of top size -> number of towers with that top, so equal
    // tops are counted instead of merged like in a TreeSet.
    static void solveTreeMap(FastScanner fs) throws IOException {
        TreeMap<Integer, Integer> tops = new TreeMap<>();
        int towers = 0;

        int n = fs.nextInt();
        while (n-- > 0) {
            int num = fs.nextInt();
            Integer top = tops.higherKey(num);
            if (top != null) {
                int cnt = tops.get(top);
                if (cnt == 1) {
                    tops.remove(top);
                } else {
                    tops.put(top, cnt - 1);
                }
            } else {
                towers++;
            }

            tops.merge(num, 1, Integer::sum);
        }

        System.out.println(towers);
    }

    // Original: fails when two towers have the same top size (TreeSet keeps one copy).
    static void solveTreeSet(FastScanner fs) throws IOException {
        TreeSet<Integer> tops = new TreeSet<>();

        int n = fs.nextInt();
        while (n-- > 0) {
            int num = fs.nextInt();
            Integer top = tops.ceiling(num + 1);
            if (top != null) {
                tops.remove(top);
            }

            tops.add(num);
        }

        System.out.println(tops.size());
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
