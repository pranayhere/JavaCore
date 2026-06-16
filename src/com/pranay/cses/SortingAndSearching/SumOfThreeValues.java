package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SumOfThreeValues {
    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int x = fs.nextInt();

        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(fs.nextInt(), i + 1);
        }

        Arrays.sort(a, Comparator.comparingInt(p -> p.val));
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = (long)a[i].val + a[l].val + a[r].val;

                if (sum == x) {
                    System.out.println(a[i].idx + " " + a[l].idx + " " + a[r].idx);
                    return;
                }

                if (sum < x) l++;
                else r--;
            }
        }

        System.out.println("IMPOSSIBLE");
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
