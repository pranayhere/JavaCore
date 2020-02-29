package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class SmallerNumberAfterSelf {
	public static void main(String[] args) {
		int[] nums = {5, 2, 6, 1};
		List<Integer> ans = countSmallerLinear(nums);
		System.out.println(ans);

		List<Integer> ans2 = countSmallerBinary(nums);
		System.out.println(ans2);
	}

	private static List<Integer> countSmallerLinear(int[] nums) {
		int[] arr = new int[2 * nums.length];
		Arrays.fill(arr, Integer.MAX_VALUE);
		Integer[] count = new Integer[nums.length];

		for (int i = nums.length - 1; i >=0; i--) {
			for (int j = 0; j < nums.length; j++) {
				if (arr[j] > nums[i]) {
					System.arraycopy(arr, j, arr, j+1, nums.length - 1);
					arr[j] = nums[i];
					count[i] = j;
					break;
				}
			}
		}
		return Arrays.asList(count);
	}

	private static List<Integer> countSmallerBinary(int[] nums) {
		Integer[] res = new Integer[nums.length];
		List<Integer> list = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			insert(list, nums[i], res, i);
		}
		return Arrays.asList(res);
	}

	private static void insert(List<Integer> list, int num, Integer[] res, int i) {
		int lo = 0;
		int hi = list.size() - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int M = list.get(mid);
			if (M >= num) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		list.add(lo, num);
		res[i] = lo;
	}
}
