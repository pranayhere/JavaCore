package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] arr = {"care", "baba", "acre", "race", "abab"};
		List<String> ans = groupAnagram(arr);
		System.out.println(ans);
	}

	private static List<String> groupAnagram(String[] arr) {
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		List<String> ans = new ArrayList<>();
		for (String str : arr) {
			String key = sort(str);
			if (hm.containsKey(key)) {
				ArrayList<String> list = hm.get(key);
				list.add(str);
				hm.put(key, list);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				hm.put(key, list);
			}
		}

		hm.forEach((k, v) -> {
			ans.addAll(v);
		});

		return ans;
	}

	private static String sort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
