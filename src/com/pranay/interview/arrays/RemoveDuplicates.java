package com.pranay.interview.arrays;

// Remove duplicates from a given string
// O(n) time and O(1) space

public class RemoveDuplicates {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		String ans = removeDuplicate(s);
		System.out.println(ans);
	}

	private static String removeDuplicate(String s) {
		char[] str = s.toCharArray();
		int[] word = new int[26];
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			int idx = str[i] - 'a';
			if (word[idx] == 1)
				continue;
			ans.append(str[i]);
			word[idx] = 1;
		}
		return ans.toString();
	}
}
