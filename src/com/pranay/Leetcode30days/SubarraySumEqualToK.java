package com.pranay.Leetcode30days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualToK {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		int k = 2;
		int count = subarraySum(nums, k);
		int count2 = subarraySum2(nums, k);
		System.out.println("Count : " + count);
	}

	private static int subarraySum2(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int count = 0;
		hm.put(0, 1);
		for (int i = 0; i< nums.length; i++) {
			sum += nums[i];
			if (hm.containsKey(sum - k)) {
				count += hm.get(sum - k);
			}
			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	private static int subarraySum(int[] nums, int k) {
		int count = 0;
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i=1; i<=nums.length; i++)
			sums[i] = sums[i-1] + nums[i - 1];

//		System.out.println(Arrays.toString(sums));

		for (int i = 0; i<sums.length; i++) {
			for (int j = i + 1; j<sums.length; j++) {
				if (sums[j] - sums[i] == k) {
					count++;
				}
			}
		}

		return count;
	}


}
