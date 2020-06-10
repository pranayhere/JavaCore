package com.pranay.Leetcode30DaysOfJune;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;

        int pos = searchInsert(nums, target);
        System.out.println("Pos : " + pos);
    }

    private static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
