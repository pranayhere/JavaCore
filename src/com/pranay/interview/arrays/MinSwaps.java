package com.pranay.interview.arrays;

/**
 * 1151. Minimum Swaps to Group All 1's Together
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together
 */

class MinSwaps {
    public static void main(String[] args) {
        int[] data = {1, 0, 1, 0, 1, 1, 0, 1};
        MinSwaps ms = new MinSwaps();
        int swaps = ms.minSwaps(data);
        System.out.println("Swaps : " + swaps);
    }

    public int minSwaps(int[] data) {
        int ones = 0;
        int zeros = 0;
        int minZeros = Integer.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1)
                ones++;
        }

        for (int i = 0; i < ones; i++) {
            if (data[i] == 0)
                zeros++;
        }

        minZeros = Integer.min(minZeros, zeros);

        int lo = 0;
        for (int hi = ones; hi < data.length; hi++) {
            if (data[lo] == 0) {
                zeros--;
            }
            lo++;

            if (data[hi] == 0)
                zeros++;

            minZeros = Math.min(minZeros, zeros);
            System.out.println(lo + " --- " + hi + " --- " + zeros + " ---- " + minZeros);
        }

        System.out.println(minZeros);

        return minZeros;
    }
}
