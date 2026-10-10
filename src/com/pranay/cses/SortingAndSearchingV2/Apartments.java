package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * https://cses.fi/problemset/task/1084
 *
 * Apartments
 *
 * There are n applicants and m free apartments. Your task is to distribute the
 * apartments so that as many applicants as possible will get an apartment.
 *
 * Each applicant has a desired apartment size, and they will accept any
 * apartment whose size is close enough to the desired size.
 *
 * Input
 * The first input line has three integers n, m, and k: the number of
 * applicants, the number of apartments, and the maximum allowed difference.
 * The next line contains n integers a1, a2, ..., an: the desired apartment
 * size of each applicant. If the desired size of an applicant is x, they will
 * accept any apartment whose size is between x - k and x + k.
 * The last line contains m integers b1, b2, ..., bm: the size of each
 * apartment.
 *
 * Output
 * Print one integer: the number of applicants who will get an apartment.
 *
 * Constraints
 * - 1 <= n, m <= 2 * 10^5
 * - 0 <= k <= 10^9
 * - 1 <= ai, bi <= 10^9
 *
 * Example
 * Input:
 * 4 3 5
 * 60 45 80 60
 * 30 60 75
 *
 * Output:
 * 2
 */

public class Apartments {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] applicants = new int[n];
        int[] apts = new int[m];

        for (int i = 0; i < n; i++) {
            applicants[i] = fs.nextInt();
        }

        for (int i = 0; i < m; i++) {
            apts[i] = fs.nextInt();
        }

        Arrays.sort(applicants);
        Arrays.sort(apts);

        int x = 0, y = 0;
        int ans = 0;
        while (x < n && y < m) {
            if (applicants[x] >= apts[y] - k && applicants[x] <=  apts[y] + k) {
                y++;
                x++;
                ans++;
            } else if (applicants[x] > apts[y]) {
                y++;
            } else {
                x++;
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
