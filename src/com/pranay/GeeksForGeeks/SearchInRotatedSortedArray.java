package com.pranay.GeeksForGeeks;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = {4, 5, 1, 2, 3};
		int target = 1;
		int position = search(nums, target);
		System.out.println("target found at : " + position);
	}

	private static int search(int[] nums, int target) {
		if(nums.length == 0){
			return -1;
		}

		int pivote = findPivote(nums);
		if (target >= nums[pivote] && target <= nums[nums.length - 1]) {
			return findTarget(nums, pivote, nums.length - 1, target);
		} else {
			return findTarget(nums, 0, pivote - 1, target);
		}
	}

	private static int findPivote(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		if(nums.length == 1 || nums[right] > nums[0]){
			return 0;
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return mid + 1;
			} else if (nums[mid - 1] > nums[mid]) {
				return mid;
			}

			if (nums[mid] > nums[0]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}

	private static int findTarget(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (target > nums[mid]) {
			return findTarget(nums, mid + 1, right, target);
		} else {
			return findTarget(nums, left, mid - 1, target);
		}

	}
}
