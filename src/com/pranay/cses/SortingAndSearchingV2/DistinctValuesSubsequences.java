package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * https://cses.fi/problemset/task/3421
 *
 * Distinct Values Subsequences
 *
 * Given an array of n integers, count the number of subsequences where each
 * element is distinct.
 *
 * A subsequence is a sequence of array elements from left to right that may
 * have gaps.
 *
 * Input
 * The first line has an integer n: the array size.
 * The second line has n integers x1, x2, ..., xn: the array contents.
 *
 * Output
 * Print the number of subsequences with distinct elements. The answer can be
 * large, so print it modulo 10^9+7.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= xi <= 10^9
 *
 * Example
 * Input:
 * 4
 * 1 2 1 3
 *
 * Output:
 * 11
 *
 * Explanation: The subsequences are [1] (two times), [2], [3], [1,2], [1,3]
 * (two times), [2,1], [2,3], [1,2,3] and [2,1,3].
 */

/**
 * Solution
 *
 * ------------------------------------------------------------
 *
 * KEY IDEA: order doesn't matter
 *
 * A subsequence is just a set of chosen positions, kept in their original
 * left-to-right order. So we only need to count sets of positions where no
 * value repeats.
 *
 * Look at each value separately. If value v appears c times, a valid
 * subsequence can contain at most one copy of v, so there are c + 1 choices:
 * leave v out, or pick exactly one of its c positions.
 *
 * Choices for different values are independent, and each combination gives a
 * different set of positions, so multiply them:
 *
 *   answer = (c1 + 1) * (c2 + 1) * ... * (ck + 1) - 1
 *
 * The "- 1" removes the case where every value is left out (the empty
 * subsequence).
 *
 * ------------------------------------------------------------
 *
 * CHECKING IT ON THE SAMPLE: 1 2 1 3
 *
 *   | Value | Count c | Choices c + 1                         |
 *   |-------|---------|---------------------------------------|
 *   |   1   |    2    | 3 (none, the first 1, the second 1)   |
 *   |   2   |    1    | 2 (none, the 2)                       |
 *   |   3   |    1    | 2 (none, the 3)                       |
 *
 *   answer = 3 * 2 * 2 - 1 = 11
 *
 * ------------------------------------------------------------
 *
 * STEPS
 *
 * 1. Count each value with a HashMap.
 * 2. Multiply all (count + 1) together, taking the result modulo 10^9+7
 *    after every multiplication.
 * 3. Subtract 1 for the empty subsequence: (ans - 1 + MOD) % MOD.
 *
 * ------------------------------------------------------------
 *
 * PITFALLS
 *
 * - Multiply by count + 1, not count: count alone drops the "leave it out"
 *   choice (1 2 3 4 5 would give 0 instead of 31).
 * - Keep ans as a long and apply the modulo after each multiplication;
 *   200000 distinct values give 2^200000, which overflows long.
 * - (ans - 1 + MOD) % MOD keeps the result non-negative if ans ends up 0.
 *
 * ------------------------------------------------------------
 *
 * TIME COMPLEXITY: O(n) — one pass to count, one pass over distinct values.
 */
public class DistinctValuesSubsequences {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        long MOD = 1_000_000_007L;
        Map<Integer, Integer> hm = new HashMap<>();
        while (n-- > 0) {
            int num = fs.nextInt();
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        long ans = 1L;
        for (int c: hm.values()) {
            ans = ans * (c + 1) % MOD;
        }

        ans = (ans - 1 + MOD) % MOD;
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
