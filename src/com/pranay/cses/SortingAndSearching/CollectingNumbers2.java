package com.pranay.cses.SortingAndSearching;

import java.util.*;
import java.io.*;

public class CollectingNumbers2 {

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
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] arr = new int[n + 1];
        int[] pos = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = fs.nextInt();
            pos[arr[i]] = i;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(pos));

        int bad = 0;
        for (int k = 2; k <= n; k++) {
            if (pos[k] <= pos[k - 1]) bad++;
        }

        for (int q = 0; q < m; q++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            int u = arr[a];
            int v = arr[b];

            if (u != v) {
                Set<Integer> affected = new HashSet<>();
                for (int k : new int[]{u, u + 1, v, v + 1}) {
                    if (k >= 2 && k <= n) affected.add(k);
                }

                for (int k : affected) {
                    if (pos[k] <= pos[k - 1]) bad--;
                }

                arr[a] = v;
                arr[b] = u;
                pos[u] = b;
                pos[v] = a;

                for (int k : affected) {
                    if (pos[k] <= pos[k - 1]) bad++;
                }
            }

            sb.append(1 + bad).append('\n');
        }

        System.out.print(sb);
    }
}