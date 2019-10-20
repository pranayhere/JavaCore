package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {
	public static void main(String[] args) {
		int[] arr = {1,5,7,8,5,3,4,2};
		int difference = -2;
		int count = longestSubsequence(arr, difference);
		System.out.println("count : " + count);
	}

	public static int longestSubsequence(int[] arr, int diff) {
		Map<Integer, Integer> hm = new HashMap<>();
		int ret = 0;
		for(int i: arr) {
			if (hm.containsKey(i - diff)) {
				int len = hm.get(i - diff) + 1;
				ret = Math.max(len, ret);
				hm.put(i, len);
			} else {
				int len = 1;
				ret = Math.max(len, ret);
				hm.put(i, len);
			}
		}
		return ret;
	}
}
