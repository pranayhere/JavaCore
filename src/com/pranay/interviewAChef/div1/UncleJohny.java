package com.pranay.interviewAChef.div1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UncleJohny {
    public static void main(String[] args) {
        UncleJohny uj = new UncleJohny();
        InputReader in = new InputReader(System.in);

        int T = in.nextInt();
        while (T > 0) {
            int N = in.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
            }

            int k = in.nextInt();

            int ans = uj.findPosition(nums, k);
            System.out.println(ans);

            T--;
        }
    }

    private int findPosition(int[] nums, int k) {
        int n = nums[k - 1];
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < n)
                lo++;
            else
                hi--;
        }

        return nums[lo] == n ? lo + 1 : -1;
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
