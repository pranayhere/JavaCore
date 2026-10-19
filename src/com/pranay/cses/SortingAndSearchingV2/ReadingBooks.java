package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;

/**
 * https://cses.fi/problemset/task/1631
 *
 * Reading Books
 *
 * There are n books, and Kotivalo and Justiina are going to read them all.
 * For each book, you know the time it takes to read it.
 *
 * They both read each book from beginning to end, and they cannot read a book
 * at the same time. What is the minimum total time required?
 *
 * Input
 * The first input line has an integer n: the number of books.
 * The second line has n integers t1, t2, ..., tn: the time required to read
 * each book.
 *
 * Output
 * Print one integer: the minimum total time.
 *
 * Constraints
 * - 1 <= n <= 2 * 10^5
 * - 1 <= ti <= 10^9
 *
 * Example
 * Input:
 * 3
 * 2 8 3
 *
 * Output:
 * 16
 */

/**
 * Solution: answer = max(S, 2M), S = sum of all times, M = longest book
 *
 * LOWER BOUND
 * - Each reader reads every book: at least S.
 * - The longest book is read twice, never at the same time: at least 2M.
 *
 * ACHIEVABLE (rest = S - M)
 * - Justiina: longest book first, then the others.
 * - Kotivalo: the others first (same order), then the longest book.
 * - Other books never clash: Kotivalo reads each one exactly M earlier than
 *   Justiina, and no other book is longer than M.
 * - M <= rest: longest book is [0, M] for Justiina and [S - M, S] for
 *   Kotivalo; M <= S - M, so no overlap. Both finish at S.
 * - M > rest: Kotivalo finishes the others at rest, waits until M, then reads
 *   the longest book in [M, 2M]. Total 2M.
 *
 * SAMPLE: 2 8 3 -> S = 13, M = 8, rest = 5 < 8, answer = 2 * 8 = 16
 *   Justiina: [8: 0-8][2: 8-10][3: 10-13]
 *   Kotivalo: [2: 0-2][3: 2-5] idle 5-8 [8: 8-16]
 *
 * Use long: S reaches 2 * 10^14 and 2M reaches 2 * 10^9.
 * TIME COMPLEXITY: O(n).
 */
public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        long max = 0L;
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            int t = fs.nextInt();
            sum += t;
            max = Math.max(max, t);
        }

        long ans = Math.max(sum, 2 * max);
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
