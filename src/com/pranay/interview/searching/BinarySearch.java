package com.pranay.interview.searching;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 5, 6};
		int k = 2;
		int pos = binarySearch(nums, k);
		System.out.println("Pos : " +pos);
	}

	private static int binarySearch(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
		    return 0;
        }
	    int lo = 0;
		int hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == k) {
				return mid;
			} else if (nums[mid] > k) {
				hi = mid - 1;
 			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}
}
