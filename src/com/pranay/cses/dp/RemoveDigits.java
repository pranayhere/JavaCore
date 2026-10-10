//package com.pranay.cses.dp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class RemoveDigits {
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
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int steps = minSteps(n);
        System.out.println(steps);
    }

    static int[] memo;

    private static int minSteps(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        String str = n + "";
        int ans = Integer.MAX_VALUE;

        for (char ch: str.toCharArray()) {
            int digit = ch - '0';
            if (digit == 0) {
                continue;
            }

            ans = Math.min(ans, 1 + minSteps(n - digit));
        }

        memo[n] = ans;
        return ans;
    }
}
