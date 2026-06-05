package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int cap = fs.nextInt();

        int[] childs = new int[n];
        for (int i = 0; i < n; i++) {
            childs[i] = fs.nextInt();
        }

        Arrays.sort(childs);

        int lo = 0;
        int hi = n - 1;
        int gandola = 0;

        while (lo <= hi) {
            if (childs[hi] + childs[lo] <= cap) {
                gandola++;
                hi--;
                lo++;
            } else {
                gandola++;
                hi--;
            }
        }

        System.out.println(gandola);
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
