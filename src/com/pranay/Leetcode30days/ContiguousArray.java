package com.pranay.Leetcode30days;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		int[] nums = {0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0};
		int size = findMaxLength(nums);
		System.out.println("Size : " + size);
	}

	private static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int count = 0;
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if (map.containsKey(count)) {
				maxLen = Math.max(maxLen, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxLen;
	}
}
