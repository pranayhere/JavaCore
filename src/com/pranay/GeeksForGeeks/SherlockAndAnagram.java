package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abba";
		int anagrams = sherlockAndAnagrams(str);
		System.out.println(anagrams);
	}

	private static int sherlockAndAnagrams(String str) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		int totalCount = 0;
		for(int i=1; i<=str.length(); i++) {
			for (int j=0; j<i; j++) {
				String substr = str.substring(j, i);
				char[] arr = substr.toCharArray();
				Arrays.sort(arr);
				String sorted = String.valueOf(arr);
				
				int value = hm.getOrDefault(sorted, 0);
				if (value > 0)
					totalCount += value;
				hm.put(sorted, ++value);
			}
		}
		return totalCount;
	}

}
