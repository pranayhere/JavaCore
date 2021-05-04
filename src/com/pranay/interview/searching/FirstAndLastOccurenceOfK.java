package com.pranay.interview.searching;

// Refer search for range for correct implementation

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastOccurenceOfK {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int k = 5;
//		int first = firstOccurence(nums, k);
//		int last = lastOccurance(nums, k);


        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        fn(l1);
        System.out.println(l1.size());

//		System.out.println("Position : " +first + " -> " + last);
	}

    private static void fn(List<Integer> l1) {
        l1 = new ArrayList<>();
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
