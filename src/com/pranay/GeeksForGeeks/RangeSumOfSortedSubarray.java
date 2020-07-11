package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4, left = 1, right = 5;

        int ans = rangeSum(nums, n, left, right);
        System.out.println("Ans : " + ans);
    }

    private static int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i< nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        System.out.println(Arrays.toString(sums));
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i<nums.length; i++) {
            int minus = 0;
            if (i != 0)
                minus = sums[i - 1];

            for (int j = i; j < nums.length; j++) {
                sum.add(sums[j] - minus);
            }
        }

        Collections.sort(sum);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += sum.get(i - 1);
        }
        System.out.println(sum);
        return ans;
    }
}
