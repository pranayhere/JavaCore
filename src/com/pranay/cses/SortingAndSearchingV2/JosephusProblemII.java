package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;

/**
 * https://cses.fi/problemset/task/2163
 *
 * Josephus Problem II
 *
 * Consider a game where there are n children (numbered 1, 2, ..., n) in a
 * circle. During the game, repeatedly k children are skipped and one child is
 * removed from the circle. In which order will the children be removed?
 *
 * Input
 * The only input line has two integers n and k.
 *
 * Output
 * Print n integers: the removal order.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 0 <= k <= 10^9
 *
 * Example
 * Input:
 * 7 2
 *
 * Output:
 * 3 6 2 7 5 1 4
 */

/**
 * Solution
 *
 * ------------------------------------------------------------
 *
 * STEP 1: track the position among the children still in the circle
 *
 * Number the remaining children 0, 1, 2, ... in their current order and keep
 * idx, the current position. Each round:
 *
 *   idx = (idx + k) % size      // skip k children, wrapping around
 *   remove the child at position idx
 *
 * After a removal, idx already points at the next child, because everyone
 * after the removed child moves down one place. "% size" handles huge k
 * (up to 10^9) in one step.
 *
 * ------------------------------------------------------------
 *
 * CHECKING IT ON THE SAMPLE: n = 7, k = 2
 *
 *   | Size | Circle        | idx = (idx + 2) % size | Removed |
 *   |------|---------------|------------------------|---------|
 *   |  7   | 1 2 3 4 5 6 7 | (0 + 2) % 7 = 2        |    3    |
 *   |  6   | 1 2 4 5 6 7   | (2 + 2) % 6 = 4        |    6    |
 *   |  5   | 1 2 4 5 7     | (4 + 2) % 5 = 1        |    2    |
 *   |  4   | 1 4 5 7       | (1 + 2) % 4 = 3        |    7    |
 *   |  3   | 1 4 5         | (3 + 2) % 3 = 2        |    5    |
 *   |  2   | 1 4           | (2 + 2) % 2 = 0        |    1    |
 *   |  1   | 4             | 0                      |    4    |
 *
 *   Output: 3 6 2 7 5 1 4
 *
 * ------------------------------------------------------------
 *
 * STEP 2: make "find the idx-th remaining child" fast
 *
 * ArrayList.remove(idx) shifts every later element: O(n) per removal,
 * about 10^10 moves for n = 200000. Too slow.
 *
 * Instead keep a Fenwick tree (binary indexed tree) over children 1..n:
 * 1 = still in the circle, 0 = removed. It keeps prefix sums, so:
 *
 *   - remove child c:              add(c, -1)                    O(log n)
 *   - find the j-th remaining one: smallest c with prefix(c) == j O(log n)
 *
 * The second one walks down the tree one bit at a time (from the highest
 * power of two <= n), so no separate binary search is needed:
 *
 *   static int kth(int j) {
 *       int pos = 0;
 *       for (int step = Integer.highestOneBit(n); step > 0; step >>= 1) {
 *           if (pos + step <= n && bit[pos + step] < j) {
 *               pos += step;
 *               j -= bit[pos];
 *           }
 *       }
 *       return pos + 1;
 *   }
 *
 * Main loop:
 *
 *   for i in 1..n: add(i, 1)
 *   idx = 0
 *   for size = n down to 1:
 *       idx = (idx + k) % size        // read k as long, it's up to 10^9
 *       child = kth(idx + 1)          // kth is 1-based
 *       print child
 *       add(child, -1)
 *
 * ------------------------------------------------------------
 *
 * PITFALLS
 *
 * - Use k % size, never walk k steps: k can be 10^9.
 * - kth takes a 1-based rank, idx is 0-based: pass idx + 1.
 * - Print with a StringBuilder: n lines of output.
 *
 * ------------------------------------------------------------
 *
 * ALTERNATIVES
 *
 * - Segment tree of counts, walking down from the root: same idea, more code.
 * - Square-root decomposition (blocks of ~sqrt(n)): O(n sqrt n), usually fast
 *   enough here too.
 *
 * ------------------------------------------------------------
 *
 * TIME COMPLEXITY: O(n log n) — n removals, each O(log n).
 */
public class JosephusProblemII {
    static int n;
    static int[] bit;   // Fenwick tree: 1 = child still in the circle, 0 = removed

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        n = fs.nextInt();
        long k = fs.nextLong();

        bit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            add(i, 1);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int size = n; size > 0; size--) {
            idx = (int) ((idx + k) % size);
            int child = kth(idx + 1);
            sb.append(child).append(' ');
            add(child, -1);
        }

        System.out.println(sb.toString().trim());
    }

    static void add(int i, int v) {
        for (; i <= n; i += i & -i) {
            bit[i] += v;
        }
    }

    // child number of the j-th remaining child (j is 1-based)
    static int kth(int j) {
        int pos = 0;
        for (int step = Integer.highestOneBit(n); step > 0; step >>= 1) {
            if (pos + step <= n && bit[pos + step] < j) {
                pos += step;
                j -= bit[pos];
            }
        }
        return pos + 1;
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
