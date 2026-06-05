package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Apartments {
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

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] applicants = new int[n];
        for (int i = 0; i < n; i++) {
            applicants[i] = sc.nextInt();
        }

        int[] apts = new int[m];
        for (int i = 0; i < m; i++) {
            apts[i] = sc.nextInt();
        }

        Arrays.sort(applicants);
        Arrays.sort(apts);

        int i = 0, j = 0;
        int ans = 0;

        while (i < n && j < m) {
            if (apts[j] >= applicants[i] - k && apts[j] <= applicants[i] + k) {
                i++;
                j++;
                ans++;
            }
            else if (applicants[i] > apts[j]) {
                j++;
            } else if (applicants[i] < apts[j]) {
                i++;
            }
        }

        System.out.println(ans);
    }
}
