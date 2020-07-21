package com.pranay.interview.arrays;

import java.util.Arrays;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;

        int count = subarraysDivByK(A, K);
        System.out.println("Num of Subarray divisible by K : " + count);
    }

    private static int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] ps = new int[N + 1];

        for (int i = 1; i < ps.length; i++)
            ps[i] = ps[i - 1] + A[i - 1];

        System.out.println(Arrays.toString(ps));

        int[] count = new int[K];
        for (int x : ps)
            count[(x % K)]++;

        System.out.println(Arrays.toString(count));

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }

}
