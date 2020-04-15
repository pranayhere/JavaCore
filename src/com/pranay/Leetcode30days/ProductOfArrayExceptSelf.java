package com.pranay.Leetcode30days;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] result = productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] fwd = new int[nums.length];
		int[] bwd = new int[nums.length];
		int[] res = new int[nums.length];
		fwd[0] = nums[0];
		for (int i = 1; i<nums.length; i++) {
			fwd[i] = fwd[i-1] * nums[i];
		}
		System.out.println(Arrays.toString(fwd));

		bwd[bwd.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >=0; i--) {
			bwd[i] = bwd[i+1] * nums[i];
		}
		System.out.println(Arrays.toString(bwd));

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				res[0] = bwd[1];
			} else if (i == nums.length - 1) {
				res[nums.length - 1] = fwd[nums.length - 2];
			} else {
				res[i] = fwd[i-1] * bwd[i+1];
			}
		}
		return res;
	}
}
