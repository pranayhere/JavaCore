package com.pranay.interview.prefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySizeSumEqualsK {
    public static void main(String[] args) {
//        int[] nums = {1, -1, 5, -2, 3};
//        int k = 3;

        int[] nums = {-2, -1, 2, 1};
        int k = 1;

        int size = maxSubArrayLen(nums, k);
        System.out.println("Size : " + size);
    }

    private static int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] ps = new int[n];
        ps[0] = nums[0];

        Map<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 1; i < n; i++)
            ps[i] = ps[i - 1] + nums[i];

        System.out.println("Prefix sum : " + Arrays.toString(ps));

        for (int i = 0; i < n; i++) {
            System.out.println(hm + " - " + max);
            if (ps[i] == k) // subarray with sum starts with index 0
                max = i + 1;
            else if (hm.containsKey(ps[i] - k)) // subarray start somewhere in the middle
                max = Math.max(max, i - hm.get(ps[i] - k));

            if (!hm.containsKey(ps[i]))
                hm.put(ps[i], i);
        }
        return max;
    }
}
