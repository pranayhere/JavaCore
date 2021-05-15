package com.pranay.interview.arrays;

// Quick find
public class FindKthSmallest {
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 2, 0};
        int ans = findKthSmallest(nums, 2);
        System.out.println("Ans : " + ans);
    }

    private static int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;

        return findKthSmallest(nums, 0, nums.length - 1, k);
    }

    private static int findKthSmallest(int[] nums, int start, int end, int k) {
        if (start > end)
            return Integer.MAX_VALUE;

        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot)
                swap(nums, left++, i);
        }
        swap(nums, left, end);

        if (left == k)
            return nums[left];
        else if (left < k)
            return findKthSmallest(nums, left + 1, end, k);
        else
            return findKthSmallest(nums, start, left - 1, k);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
