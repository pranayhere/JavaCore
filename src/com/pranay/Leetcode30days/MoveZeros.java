package com.pranay.Leetcode30days;

import java.util.Arrays;

public class MoveZeros {
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		int[] ans = moveZeroes(nums);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] moveZeroes(int[] nums) {
		int ptr = 0;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] != 0) {
				nums[ptr] = nums[i];
				ptr++;
			}
		}
		while (ptr < nums.length) {
			nums[ptr++] = 0;
		}
		return nums;
	}
}
