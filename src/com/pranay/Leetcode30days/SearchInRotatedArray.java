package com.pranay.Leetcode30days;

public class SearchInRotatedArray {
	public static void main(String[] args) {
		int[] nums = {7,8,1,2,3,4,5,6};
		int target = 2;
		int pos = search(nums, target);
		System.out.println("Position : " +pos);
	}

	private static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int pivot = findPivote(nums);
		System.out.println("pivote : " + pivot);
		int pos = -1;
		if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
			pos = binarySearch(nums, target, pivot, nums.length - 1);
		} else {
			pos = binarySearch(nums, target, 0, pivot - 1);
		}
		return pos;
	}

	private static int binarySearch(int[] nums, int target, int lo, int hi) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	private static int findPivote(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;

		if(nums.length == 1 || nums[hi] > nums[0]){
			return 0;
		}

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return mid + 1;
			} else if (nums[mid - 1] > nums[mid]) {
				return mid;
			}

			if (nums[mid] > nums[0]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return 0;
	}
}
