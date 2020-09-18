package com.pranay.interview.arrays;

public class MaximumXORofTwoNumbers {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int max = findMaximumXOR(nums);
        System.out.println("Max : " + max);
    }

    public static int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) > max) {
                    max = nums[i] ^ nums[j];
                }
            }
        }
        return max;
    }
}
