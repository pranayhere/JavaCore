package com.pranay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcatenatedStringWithUniqueCharacters {
	public static void main(String[] args) {
		List<String> arr = Arrays.asList(new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"});
		int maxLen = maxLength(arr);
		System.out.println(maxLen);
	}

	private static int maxLength(List<String> arr) {
		int max = 0;
		if (arr.isEmpty()) {
			return 0;
		}

		if (arr.size() == 1) {
			return arr.get(0).length();
		}

		List<List<String>> ans = new ArrayList<>();
		boolean[] marked = new boolean[arr.size()];
		helper(new ArrayList<>(), ans, marked, arr);
		for (List<String> list: ans) {
			System.out.println(list.toString());
		}
		return 0;
	}

	private static void helper(List<String> list, List<List<String>> ans, boolean[] marked, List<String> arr)
	{
		ans.add(new ArrayList<>(list));
		for(int i = 0; i < arr.size(); i++)
		{
			if(marked[i]) continue;
			list.add(arr.get(i));
			marked[i] = true;
			helper(list, ans, marked, arr);
			list.remove(list.size()-1);
			marked[i] = false;
		}
	}
}