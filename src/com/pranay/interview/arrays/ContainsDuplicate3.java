package com.pranay.interview.arrays;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/
 * Sol :
 * https://leetcode.com/problems/contains-duplicate-iii/solution/
 */
public class ContainsDuplicate3 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1, t = 2;

        boolean ans = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("Contains Duplicate? : " + ans);
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && ceil <= nums[i] + t)
                return true;

            Integer floor = set.floor(nums[i]);
            if (floor != null && floor + t >= nums[i])
                return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
