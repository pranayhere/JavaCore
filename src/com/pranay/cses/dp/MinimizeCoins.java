package com.pranay.cses.dp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MinimizeCoins {
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
        int sum = fs.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = fs.nextInt();
        }

        memo = new Integer[sum + 1][n + 1];

        int ans = minCoins(coins, sum, n);
        if (ans == Integer.MAX_VALUE - 1)
            ans = -1;

        System.out.println(ans);

        int res = minCoinsTab(coins, sum, n); // Tabulation
        System.out.println(res);
    }

    public static int minCoinsTab(int[] coins, int sum, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);


        return 0;
    }

    static Integer[][] memo;

    public static int minCoins(int[] coins, int sum, int n) {
        if (n == 0 || sum <= 0) {
            return sum == 0 ? 0 : Integer.MAX_VALUE - 1;
        }

        if (memo[sum][n] != null) {
            return memo[sum][n];
        }

        if (sum >= coins[n - 1]) {
            memo[sum][n] = Math.min(1 + minCoins(coins, sum - coins[n - 1], n), minCoins(coins, sum, n - 1));
        } else {
            memo[sum][n] = minCoins(coins, sum, n - 1);
        }

        return memo[sum][n];
    }
}
