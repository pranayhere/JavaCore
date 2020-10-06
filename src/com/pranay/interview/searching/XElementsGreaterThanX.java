package com.pranay.interview.searching;

import java.util.Arrays;

public class XElementsGreaterThanX {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        XElementsGreaterThanX x = new XElementsGreaterThanX();
        int ans = x.specialArray(nums);
        System.out.println("Ans : " + ans);
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int tmp = nums.length - search(nums, i);
            if (tmp == i)
                return tmp;
        }
        return -1;
    }

    public int search(int[] nums, int val) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (val > nums[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
