package com.pranay.interview.searching;

public class FindInSortedAndRotatedArray {
	public static void main(String[] args) {
		int[] nums = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		int k = 234;
		int pos = findInSortedAndRotatedArray(nums, k);
		System.out.println("Position : " + pos);
	}

	private static int findInSortedAndRotatedArray(int[] nums, int k) {
		int pivote = findPivote(nums);
		int pos = -1;
		if (k >= nums[pivote] && k <= nums[nums.length - 1]) {
		    pos = binarySearch(nums, pivote, nums.length - 1, k);
        } else {
		    pos = binarySearch(nums, 0, pivote - 1, k);
        }
	    return pos;
	}

    private static int binarySearch(int[] nums, int lo, int hi, int k) {
	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        if (nums[mid] == k) {
	            return mid;
            } else if (k > nums[mid]) {
	            lo = mid + 1;
            } else {
	            hi = mid - 1;
            }
        }
	    return -1;
    }

    private static int findPivote(int[] nums) {
	    int lo = 0, hi = nums.length - 1;
	    if (nums.length == 1 || nums[hi] > nums[0]) {
	        return 0;
        }

	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        if (nums[mid] > nums[mid + 1]) {
	            return mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
	            return mid;
            }

	        if (nums[mid] > nums[0])
	            lo = mid + 1;
	        else
	            hi = mid - 1;
        }
	    return 0;
    }
}
