package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

/**
 * https://cses.fi/problemset/task/1620
 *
 * Factory Machines
 *
 * A factory has n machines which can be used to make products. Your goal is
 * to make a total of t products.
 *
 * For each machine, you know the number of seconds it needs to make a single
 * product. The machines can work simultaneously, and you can freely decide
 * their schedule.
 *
 * What is the shortest time needed to make t products?
 *
 * Input
 * The first input line has two integers n and t: the number of machines and
 * products.
 * The next line has n integers k1, k2, ..., kn: the time needed to make a
 * product using each machine.
 *
 * Output
 * Print one integer: the minimum time needed to make t products.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= t <= 10^9
 * - 1 <= ki <= 10^9
 *
 * Example
 * Input:
 * 3 7
 * 3 2 5
 *
 * Output:
 * 8
 *
 * Explanation: Machine 1 makes two products, machine 2 makes four products and
 * machine 3 makes one product.
 */

/**
 * Solution: binary search on the answer
 *
 * ------------------------------------------------------------
 *
 * KEY IDEA
 *
 * Instead of scheduling the machines, guess a time T and check if it's enough.
 * In T seconds, machine k makes floor(T / k) products, and all machines work
 * at the same time:
 *
 *   made(T) = T/k1 + T/k2 + ... + T/kn      (integer division)
 *
 * A larger T never makes fewer products, so binary-search the smallest T
 * with made(T) >= t.
 *
 * ------------------------------------------------------------
 *
 * EXAMPLE: t = 7, machines 3 2 5
 *
 * lo = 0, hi = 2 * 7 = 14 (fastest machine alone makes all 7)
 *
 *   | lo | hi | mid | made(mid) = mid/3 + mid/2 + mid/5 | >= 7? | next    |
 *   |----|----|-----|-----------------------------------|-------|---------|
 *   |  0 | 14 |  7  | 2 + 3 + 1 = 6                     |  no   | lo = 8  |
 *   |  8 | 14 | 11  | 3 + 5 + 2 = 10                    |  yes  | hi = 11 |
 *   |  8 | 11 |  9  | 3 + 4 + 1 = 8                     |  yes  | hi = 9  |
 *   |  8 |  9 |  8  | 2 + 4 + 1 = 7                     |  yes  | hi = 8  |
 *
 * lo == hi == 8, so the answer is 8.
 *
 * ------------------------------------------------------------
 *
 * COMPLEXITY: about 60 binary-search steps (log2 of 10^18), each looping over
 * n machines: O(n log(min(k) * t)).
 *
 * REMEMBER
 * - Use long everywhere: the answer can reach 10^18.
 * - Stop summing once made >= t, or the sum itself can overflow.
 */
public class FactoryMachines {
    public static void main(String[] args) throws IOException {
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

    public static void usingMath() throws IOException{
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int t = fs.nextInt();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = fs.nextInt();
            int tasks = t / curr;
            if (t % curr > 0) {
                tasks++;
            }

            int time = tasks * curr;
            ans = Math.min(ans, time);
        }

        System.out.println(ans);
    }

    public static void usingPQ() throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int t = fs.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [currTime, time needed for machine];
        for (int i = 0; i < n; i++) {
            int time = fs.nextInt();
            pq.offer(new int[]{time, time});
        }

        while (!pq.isEmpty()) {
            int[] completed = pq.poll();
            t--;

            if (t == 0) {
                System.out.println(completed[0]);
                return;
            }

            pq.offer(new int[]{completed[0] + completed[1], completed[1]});
        }
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
