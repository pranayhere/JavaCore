package com.pranay.cses.dp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CoinCombinations1 {
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

        memo = new long[sum + 1];
        Arrays.fill(memo, -1);
        long ways = coinWays(coins, sum);
        System.out.println(ways);

        long ways2 = coinWaysTabu(coins, sum);
        System.out.println(ways2);
    }

    static long[] memo;
    static final int MOD = 1_000_000_007;

    public static long coinWaysTabu(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int s = 1; s <= sum; s++) {
            for (int coin: coins) {
                if (s >= coin) {
                    dp[s] = (dp[s] + dp[s - coin]) % MOD;
                }
            }
        }

        return dp[sum];
    }

    public static long coinWays(int[] coins, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (memo[sum] != -1) {
            return memo[sum];
        }

        long ways = 0;
        for (int i = 0; i < coins.length; i++) {
            if (sum >= coins[i]) {
                ways = (ways + coinWays(coins, sum - coins[i])) % MOD;
            }
        }

        memo[sum] = ways;
        return ways;
    }
}
