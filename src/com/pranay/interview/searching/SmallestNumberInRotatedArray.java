package com.pranay.interview.searching;

public class SmallestNumberInRotatedArray {
	public static void main(String[] args) {
		int[] nums = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		int pos = smallestElement(nums);
		System.out.println("Position : " + pos);
	}

	private static int smallestElement(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
