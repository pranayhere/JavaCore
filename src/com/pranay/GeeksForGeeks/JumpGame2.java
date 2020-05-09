package com.pranay.GeeksForGeeks;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */

public class JumpGame2 {
	public static void main(String[] args) {
		int[] nums = {0,2,3};
		int minJumps = jump2(nums);
		System.out.println(minJumps);
	}


	private static int jump2(int[] nums) {
		int[] count = new int[nums.length];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;
		for (int i = 1; i<nums.length; i++) {
			for (int j = 0; j<i; j++) {
				if (i <= j + nums[j] && count[j] + 1 < count[i]) {
					count[i] = count[j] + 1;
				}
			}
		}
        System.out.println(Arrays.toString(count));
		return count[count.length - 1];
	}
}