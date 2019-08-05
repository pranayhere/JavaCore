package com.pranay.GeeksForGeeks;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(nums, target);
        System.out.println("range is : " +range[0]+ " to " +range[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;

        return new int[] {leftIdx, rightIdx};
    }

    private static int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
