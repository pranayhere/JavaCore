package com.pranay.interview.searching;

public class RandomPickWithWeight {
    int[] prefixSum;
    int totalSum;
    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
            totalSum += w[i];
        }
    }

    private int pickIndex() {
        double target = totalSum * Math.random();

        int lo = 0, hi = prefixSum.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > prefixSum[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        RandomPickWithWeight rp = new RandomPickWithWeight(new int[]{1, 3});
        System.out.println(rp.pickIndex()); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
        System.out.println(rp.pickIndex()); // return 1
        System.out.println(rp.pickIndex()); // return 1
        System.out.println(rp.pickIndex()); // return 1
        System.out.println(rp.pickIndex()); // return 0. It's returning the first element (index = 0) that has probability of 1/4.
    }
}
