package com.pranay.interview.searching;

public class FindInSortedAndRotatedArray {
	public static void main(String[] args) {
		int[] nums = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		int k = 234;
		int pos = findInSortedAndRotatedArray(nums, k);
		System.out.println("Position : " + pos);
	}

	private static int findInSortedAndRotatedArray(int[] nums, int k) {
		int pos = findSmallestElementInArray(nums);
		if (k > nums[nums.length - 1]) {
			return binarySearch(nums, 0, pos - 1 ,k);
		} else {
			return binarySearch(nums, pos, nums.length - 1, k);
		}
	}

	private static int binarySearch(int[] nums, int lo, int hi, int k) {
		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == k) {
				return mid;
			} else if (nums[mid] < k) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	private static int findSmallestElementInArray(int[] nums) {
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
