package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://cses.fi/problemset/task/1619
 *
 * Restaurant Customers
 *
 * You are given the arrival and leaving times of n customers in a restaurant.
 *
 * What was the maximum number of customers in the restaurant at any time?
 *
 * Input
 * The first input line has an integer n: the number of customers.
 * After this, there are n lines that describe the customers. Each line has two
 * integers a and b: the arrival and leaving times of a customer.
 * You may assume that all arrival and leaving times are distinct.
 *
 * Output
 * Print one integer: the maximum number of customers.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= a < b <= 10^9
 *
 * Example
 * Input:
 * 3
 * 5 8
 * 2 4
 * 3 9
 *
 * Output:
 * 2
 */
public class RestaurantCustomers {
//    public static void main(String[] args) throws IOException {
//        FastScanner fs = new FastScanner(System.in);
//        TreeMap<Integer, Integer> tm = new TreeMap<>();
//
//        int n = fs.nextInt();
//        for (int i = 0; i < n; i++) {
//            int arr = fs.nextInt();
//            int dept = fs.nextInt();
//
//            tm.put(arr, tm.getOrDefault(arr, 0) + 1);
//            tm.put(dept, tm.getOrDefault(dept, 0) - 1);
//        }
//
//        int count = 0;
//        int ans = 0;
//
//        for (int curr: tm.keySet()) {
//            count += tm.get(curr);
//            ans = Math.max(ans, count);
//        }
//
//        System.out.println(ans);
//    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] arr = new int[n];
        int[] dept = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            dept[i] = fs.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(dept);

        int i = 0, j = 0, count = 0, ans = 0;
        while (i < n) {
            if (arr[i] < dept[j]) {
                i++;
                count++;
                ans = Math.max(ans, count);
            } else {
                j++;
                count--;
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
