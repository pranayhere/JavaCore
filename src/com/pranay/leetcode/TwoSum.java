package com.pranay.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] arr = twoSum(nums, target);
		System.out.println(arr[0] + " " +arr[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            int ans = target - nums[i];
            if (hm.containsKey(nums[i])) {
                arr[0] = hm.get(nums[i]);
                arr[1] = i;
                break;
            }
            hm.put(ans, i);
            
            // hm.forEach((k,v) -> {
            //     System.out.println("k : "+k+" v: "+v);
            // });
            // System.out.println();
        }
        return arr;
    }
}
