package com.pranay.interview.hashing;

// Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        int maxLen = findMaxLength(nums);
        System.out.println("Max len : " + maxLen);
    }

    private static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0 ? -1 : 1);
            System.out.println(count);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
