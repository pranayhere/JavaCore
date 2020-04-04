package com.pranay.interview.searching;

public class FirstAndLastOccurenceOfK {
	public static void main(String[] args) {
		int[] nums = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		int k = 285;
		int first = firstOccurence(nums, k);
		int last = lastOccurance(nums, k);

		System.out.println("Position : " +first + " -> " + last);
	}

	private static int firstOccurence(int[] nums, int k) {
		int lo = 0;
		int hi = nums.length;

		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == k && nums[mid - 1] != k) {
				return mid;
			} else if (nums[mid] >= k) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	private static int lastOccurance(int[] nums, int k) {
		int lo = 0;
		int hi = nums.length;

		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == k && nums[mid + 1] != k) {
				return mid;
			} else if (nums[mid] <= k) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
