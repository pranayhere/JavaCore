package com.pranay.cses.SortingAndSearching;

/**
 * Given an array of n integers, count the number of subarrays where each element is distinct.
 * Input
 * The first line has an integer n: the array size.
 * The second line has n integers x_1,x_2,\dots,x_n: the array contents.
 * Output
 * Print the number of subarrays with distinct elements.
 * Constraints
 *
 * 1 \le n \le 2 \cdot 10^5
 * 1 \le x_i \le 10^9
 *
 * Example
 * Input:
 * 4
 * 1 2 1 3
 *
 * Output:
 * 8
 *
 * Explanation: The subarrays are [1] (two times), [2], [3], [1,2], [1,3], [2,1] and [2,1,3].
 */

/**
 * Solution:
 * common pattern to count subarray.
 * We increment count by 1 if unique value,
 * else
 * when it's not unique value, we need to add length of the subarray that is unique.
 *
 * At the end to simplify, we can always add length of current subarray, as if the value
 * if unique, it increments by 1, and when it's non-unique, we remove from left untill we
 * get the unique subarray, and add it's length.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DistinctValuesSubarray {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] nums = new int[n];
        Map<Integer, Integer> hm = new HashMap<>();
        long cnt = 0;
        long ans = 0;
        int lo = 0;

        for (int hi = 0; hi < n; hi++) {
            int num = fs.nextInt();
            nums[hi] = num;
            hm.put(num, hm.getOrDefault(num, 0) + 1);

            while (hm.get(num) > 1) {
                int rm = nums[lo++];
                hm.put(rm, hm.get(rm) - 1);
                if (hm.get(rm) == 0) {
                    hm.remove(rm);
                }
            }

            cnt = hi - lo + 1;
            ans += cnt;
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
