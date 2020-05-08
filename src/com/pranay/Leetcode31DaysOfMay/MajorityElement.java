package com.pranay.Leetcode31DaysOfMay;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,2,4,4,4,3,3};
        int num = majorityElement2(nums);
        System.out.println("Majoruty element : " + num);
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int k = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > k) {
                return num;
            }
        }
        return -1;
    }

    private static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
