package com.pranay.Leetcode31DaysOfMay;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
//       1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6};
        int element = singleNonDuplicate(nums);
        System.out.println("Element : " + element);
    }

    private static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
