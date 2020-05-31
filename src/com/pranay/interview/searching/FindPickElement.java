package com.pranay.interview.searching;

public class FindPickElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int idx = findPeakElement(nums);
        System.out.println("Index : " + idx);
    }

    private static int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
