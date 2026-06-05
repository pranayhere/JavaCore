//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

/**
 * A factory has n machines which can be used to make products. Your goal is to make a total of t products.
 * For each machine, you know the number of seconds it needs to make a single product. The machines can work simultaneously, and you can freely decide their schedule.
 * What is the shortest time needed to make t products?
 * Input
 * The first input line has two integers n and t: the number of machines and products.
 * The next line has n integers k_1,k_2,\dots,k_n: the time needed to make a product using each machine.
 * Output
 * Print one integer: the minimum time needed to make t products.
 * Constraints
 *
 * 1 \le n \le 2 \cdot 10^5
 * 1 \le t \le 10^9
 * 1 \le k_i \le 10^9
 *
 * Example
 * Input:
 * 3 7
 * 3 2 5
 *
 * Output:
 * 8
 *
 * Explanation: Machine 1 makes two products, machine 2 makes four products and machine 3 makes one product.
 */
public class FactoryMachines {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long t = fs.nextLong();

        long[] machines = new long[n];
        long minMachine = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            machines[i] = fs.nextLong();
            minMachine = Math.min(minMachine, machines[i]);
        }

        long lo = 1;
        long hi = minMachine * t;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(machines, mid, t)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }

    public static boolean check(long[] machines, long time, long target) {
        int products = 0;

        for (long machine: machines) {
            products += (int) (time / machine);
            if (products >= target)
                return true;
        }

        return false;
    }

    public static void main2(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int t = fs.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0]: a[1] - b[1]); // speed, end_time
        for (int i = 0; i < n; i++) {
            int k = fs.nextInt();
            pq.offer(new int[]{k, k});
        }

        int time = 0;
        for (int i = 0; i < t; i++) {
            int[] curr = pq.poll();

            int currTime = curr[1];
            int speed = curr[0];

            time = Math.max(time, currTime);
            pq.offer(new int[]{speed, currTime + speed});
        }

        System.out.println(time);
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
