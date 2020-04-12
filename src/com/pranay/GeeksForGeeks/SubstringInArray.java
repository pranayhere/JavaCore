package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class SubstringInArray {
	public static void main(String[] args) {
		String[] words = {"leetcoder","leetcode","od","hamlet","am"};
		List<String> ans = stringMatching(words);
		System.out.println(ans);
	}

	private static List<String> stringMatching(String[] words) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i<words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j) {
					continue;
				} else {
					if (words[j].contains(words[i])) {
						result.add(words[i]);
						break;
					}
				}
			}
		}
		return result;
	}
}
