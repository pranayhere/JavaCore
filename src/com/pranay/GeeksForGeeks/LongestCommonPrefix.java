package com.pranay.GeeksForGeeks;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"flower","flow","flight"};
		String commonPrefix = longestCommonPrefix(strs);
		System.out.println(commonPrefix);
	}
	
	// Get the smallest string size
	// Binary search to get the middle index of the smallest length string
	// get the substring of the 0th string from 0...mid
	// check if the substring exists in all the strings
	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
	        return "";
		int minStrLen = Integer.MAX_VALUE;
		for (String str : strs) {
			minStrLen = Math.min(minStrLen, str.length());
		}
		
		int low = 1;
		int high = minStrLen;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (checkPrefix(strs, mid))
				low = mid + 1;
			else
				high = mid - 1;
		}
		return strs[0].substring(0, (low + high) / 2);
	}

	private static boolean checkPrefix(String[] strs, int mid) {
		String prefix = strs[0].substring(0, mid);
		for (String str : strs)
			if (!str.startsWith(prefix))
				return false;
		return true;
	}

}
