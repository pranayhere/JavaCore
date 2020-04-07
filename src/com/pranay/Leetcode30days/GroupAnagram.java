package com.pranay.Leetcode30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = groupAnagrams(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, ArrayList<String>> hm = new HashMap<>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);

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

		List<List<String>> ans = new ArrayList<>();
		hm.forEach((k, v) -> {
			ans.add(v);
		});
		return ans;
	}
}
