package com.pranay.cses.SortingAndSearching;

/**
 * Given an array of n integers, your task is to count the number of subarrays where the sum of values is divisible by n.
 * Input
 * The first input line has an integer n: the size of the array.
 * The next line has n integers a_1,a_2,\dots,a_n: the contents of the array.
 * Output
 * Print one integer: the required number of subarrays.
 * Constraints
 *
 * 1 \le n \le 2 \cdot 10^5
 * -10^9 \le a_i \le 10^9
 *
 * Example
 * Input:
 * 5
 * 3 1 2 7 4
 *
 * Output:
 * 1
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SubarrayDivisibility {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        Map<Long, Long> hm = new HashMap<>();
        hm.put(0L, 1L);
        long sum = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int curr = fs.nextInt();

            sum += curr;
            long mod = ((sum % n) + n) % n;

            if (hm.containsKey(mod)) {
                count += hm.get(mod);
            }

            hm.put(mod, hm.getOrDefault(mod, 0L) + 1);
//            System.out.println(hm + " --- " + count);
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
