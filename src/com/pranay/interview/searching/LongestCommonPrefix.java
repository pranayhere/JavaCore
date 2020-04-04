package com.pranay.interview.searching;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		String longestCommonPrefix = longestCommonPrefix(strs);
		System.out.println("longestCommonPrefix : " + longestCommonPrefix);
	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		int minStrLen = Integer.MAX_VALUE;
		for (String str: strs) {
			minStrLen = Math.min(str.length(), minStrLen);
		}

		int lo = 0;
		int hi = minStrLen;

		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (checkPrefix(strs, mid)) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return null;
	}

	private static boolean checkPrefix(String[] strs, int mid) {
		String prefix = strs[0].substring(0, mid);
		for (String str: strs) {
			if (!str.startsWith(prefix))
				return false;
		}
		return true;
	}
}
