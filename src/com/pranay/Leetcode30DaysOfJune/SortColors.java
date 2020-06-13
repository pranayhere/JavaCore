package com.pranay.Leetcode30DaysOfJune;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColorsSinglePass(nums);
    }

    private static void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0)
                zeros++;
            else if (nums[i] == 1)
                ones++;
            else
                twos++;
        }

        for (int i = 0; i < zeros; i++) {
            nums[i] = 0;
        }

        for (int i = zeros; i < ones + zeros; i++) {
            nums[i] = 1;
        }

        for (int i = ones + zeros; i< twos + ones + zeros; i++) {
            nums[i] = 2;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void sortColorsSinglePass(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                int temp = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = temp;
                curr++;
                p0++;
            } else if (nums[curr] == 2) {
                int temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else
                curr++;
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
    }

}
