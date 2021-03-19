package com.pranay.interview.searching;

public class EntryEqualToIndex {
	public static void main(String[] args) {
		int[] nums = {-2, 0, 2, 3, 6, 7, 9};
		int pos = findEntryEqualToIndex(nums);
		System.out.println("Pos : " + pos);
	}

	private static int findEntryEqualToIndex(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			int diff = nums[mid] - mid;
			if (diff == 0) {
				return mid;
			} else if (diff > 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}
}