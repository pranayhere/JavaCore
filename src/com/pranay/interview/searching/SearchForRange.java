package com.pranay.interview.searching;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class SearchForRange {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 7;

        int[] range = searchRange(nums, target);
        System.out.println(Arrays.toString(range));
    }

    private static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[] {-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int findLast(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }
}
