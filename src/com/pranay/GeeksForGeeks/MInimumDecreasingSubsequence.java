package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MInimumDecreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {6};
		List<Integer> minSeq = minSubsequence(nums);
		System.out.println(minSeq);
	}

	private static List<Integer> minSubsequence(int[] nums) {
		Arrays.sort(nums);
		int[] arr = IntStream.rangeClosed(1, nums.length).map(i -> nums[nums.length-i]).toArray();
		System.out.println(Arrays.toString(arr));

		int totalSum = 0;
		for (int i =0 ;i < arr.length; i++) {
			totalSum += arr[i];
		}
		int currSum = 0;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i< arr.length; i++) {
			currSum += arr[i];
			ans.add(arr[i]);
			if (totalSum - currSum < currSum) {
				break;
			}
		}
		return ans;
	}

}
