package com.pranay.interview.arrays.permutation;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] permute = nextPermutation(nums);
        System.out.println("Next Permutation : " + Arrays.toString(permute));
    }

    private static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i] > nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1);

        return nums;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;

        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
