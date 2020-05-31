package com.pranay.interview.searching;

public class MinumumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        int min = findMin(nums);
        System.out.println("Min in Array : " + min);
    }

    private static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums.length == 1 || nums[0] < nums[hi]) {
            return nums[0];
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
