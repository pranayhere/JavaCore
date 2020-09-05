package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        boolean ans = containsNearbyDuplicate(nums, k);
        System.out.println("Ans : " + ans);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int idx = hm.get(nums[i]);
                if (Math.abs(idx - i) <= k)
                    return true;
            }

            hm.put(nums[i], i);
        }
        return false;
    }
}
