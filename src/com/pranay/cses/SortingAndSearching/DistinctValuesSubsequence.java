//package com.pranay.cses.SortingAndSearching;

import java.io.*;
import java.util.*;

public class DistinctValuesSubsequence {
    static final long MOD = 1_000_000_007L;

    static long modInv(long a) {
        long res = 1;
        long b = MOD - 2;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
        }

        Map<Integer, Long> freq = new HashMap<>();

        long prod = 1;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int val = x[i];

            long f = freq.getOrDefault(val, 0L);

            // contribution of this element
            long seqs = (prod * modInv(f + 1)) % MOD;
            ans = (ans + seqs) % MOD;

            // update freq
            long newF = f + 1;
            freq.put(val, newF);

            // update prod:
            // remove (f+1), add (f+2)
            prod = (prod * (newF + 1)) % MOD;
            prod = (prod * modInv(newF)) % MOD;
        }

        System.out.println(ans % MOD);
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
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }
}