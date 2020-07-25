package com.pranay.interview.searching;

public class MinimumInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 10,10,10};
        int min = findMin(nums);
        System.out.println("Min : " + min);
    }

    private static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 1 || nums[0] < nums[hi])
            return nums[0];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int M = nums[mid];

            if (M < nums[0])
                hi = mid - 1;
            else if (M > nums[0])
                lo = mid + 1;
            else
                hi -= 1; // this makes O(n)
        }

        return lo >= nums.length ? nums[0] : nums[lo];
    }


}
