package com.pranay.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class TripletSumToZero {
	public static void main(String[] args) {
		int nums[] = {0, -1, 2, -3, 1};
		tripletSumToZero(nums);
	}

	private static void tripletSumToZero(int[] nums) {
		for (int i = 0; i<nums.length; i++) {
			Set<Integer> hs = new HashSet<>();
			for (int j = i+1; j<nums.length; j++) {
				int x = -(nums[i] + nums[j]);
				if (hs.contains(x)) {
					System.out.println(x+ " "+nums[i] +" "+ nums[j]);
				} else {
					hs.add(nums[j]);
				}
			}
		}
	}
}
