//package com.pranay.cses.SortingAndSearchingV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public class NearestSmallestValue {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = fs.nextInt();

        Stack<Integer> stk = new Stack<>();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            nums[i] = num;

            while (!stk.isEmpty() && nums[stk.peek()] >= num) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stk.peek() + 1).append(" ");
            }

            stk.push(i);
        }

        System.out.println(sb.toString().trim());
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
