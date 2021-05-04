package com.pranay.interview.searching;

public class LargestInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {6, 7, 8, 1, 4};
        int ans = findLargest(nums);
        System.out.println("Largest element is : " + ans);
    }

    private static int findLargest(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }

        if (lo == 0)
            return nums[nums.length - 1];

        return nums[lo - 1];
    }
}
