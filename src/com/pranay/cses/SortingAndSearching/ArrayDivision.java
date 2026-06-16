//package com.pranay.cses.SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;

/**
 * You are given an array containing n positive integers.
 * Your task is to divide the array into k subarrays so that the maximum sum in a subarray is as small as possible.
 * Input
 * The first input line contains two integers n and k: the size of the array and the number of subarrays in the division.
 * The next line contains n integers x_1,x_2,\ldots,x_n: the contents of the array.
 * Output
 * Print one integer: the maximum sum in a subarray in the optimal division.
 * Constraints
 *
 * 1 \le n \le 2 \cdot 10^5
 * 1 \le k \le n
 * 1 \le x_i \le 10^9
 *
 * Example
 * Input:
 * 5 3
 * 2 4 7 3 5
 *
 * Output:
 * 8
 *
 * Explanation: An optimal division is [2,4],[7],[3,5] where the sums of the subarrays are 6,7,8. The largest sum is the last sum 8.
 */
public class ArrayDivision {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] nums = new int[n];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        long lo = max;
        long hi = sum;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (divisions(nums, mid) > k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        System.out.println(lo);
    }

    public static int divisions(int[] nums, long maxSumAllowed) {
        int count = 1;
        long sum = 0;

        for (int num : nums) {
            if (sum + num <= maxSumAllowed) {
                sum += num;
            } else {
                count++;
                sum = num;
            }
        }

        return count;
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
