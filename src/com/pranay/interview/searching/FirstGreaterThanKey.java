package com.pranay.interview.searching;

public class FirstGreaterThanKey {
	public static void main(String[] args) {
		int[] nums = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		int k = 108;
		int pos = firstGreaterThanK(nums, k);
		System.out.println("position : " + pos);
	}

	private static int firstGreaterThanK(int[] nums, int k) {
		int lo = 0;
		int hi = nums.length;

		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == k && nums[mid + 1] != k) {
				return mid + 1;
			} else if (nums[mid] <= k) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
